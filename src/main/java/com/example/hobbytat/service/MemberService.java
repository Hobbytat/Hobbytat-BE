package com.example.hobbytat.service;

import com.example.hobbytat.controller.dto.request.PutProfileRequestDto;
import com.example.hobbytat.controller.dto.response.PostSignUpResponseDto;
import com.example.hobbytat.controller.dto.response.PutProfileResponseDto;
import com.example.hobbytat.controller.dto.response.SimpleArticleRankResponseDto;
import com.example.hobbytat.domain.Article;
import com.example.hobbytat.domain.HobbyType;
import com.example.hobbytat.domain.Member;
import com.example.hobbytat.exception.NoSuchEntityException;
import com.example.hobbytat.repository.MemberRepository;
import com.example.hobbytat.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {
    private final MemberRepository memberRepository;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public String makeToken(String username, String password) {

        UsernamePasswordAuthenticationToken authenticationFilter
                = new UsernamePasswordAuthenticationToken(username, password);

        Authentication authentication = null;

        try {
            authentication = authenticationManagerBuilder.getObject().authenticate(authenticationFilter);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

        return jwtTokenProvider.generateToken(authentication);
    }

    @Transactional
    public PostSignUpResponseDto save(Member member) {
        String password = member.getPassword();
        member.setPassword(passwordEncoder.encode(password));
        memberRepository.save(member);

        return PostSignUpResponseDto.toDto(member);
    }


    public boolean checkNickname(String nickname) {
        // Nickname 있으면 false, 없으면 true 반환
        return !memberRepository.existsByNickname(nickname);
    }

    public boolean checkUsername(String username) {
        // Username 있으면 false, 없으면 true 반환
        return !memberRepository.existsByUsername(username);
    }

    public Member findMemberById(Long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(() -> new NoSuchEntityException("해당하는 멤버가 존재하지 않습니다."));
    }

    public HobbyType getHobbyType(List<Boolean> data) {
        /*
        I 개인 vs G 그룹
        N 실내 vs O 실외
        S 정적 vs D 동적
        C 창의 vs A 분석
        예술가 - INDC, GNDC
        탐험가 - GODC, GOSC, IODC, IOSC
        스포츠맨 - GODA, IODA
        취미공예가 - INSC
        지식탐구가 - IOSA, GOSA
        예술적인 취미 공예가- GNSC
        지적인 스포츠맨 - GNDA, INDA
        지적인 취미 공예가 - INSA, GNSA
         */
        int countI = countTrues(data.get(0), data.get(4), data.get(8));
        int countN = countTrues(data.get(1), data.get(5), data.get(9));
        int countS = countTrues(data.get(2), data.get(6), data.get(10));
        int countC = countTrues(data.get(3), data.get(7), data.get(11));
        String typeInit = "";
        typeInit += (countI >= 2) ? "I" : "G";
        typeInit += (countN >= 2) ? "N" : "O";
        typeInit += (countS >= 2) ? "S" : "D";
        typeInit += (countC >= 2) ? "C" : "A";

//        ARTIST, EXPLORER, SPORTSMAN, HOBBYCRAFTER, KNOWLEDGESEEKER,
//                ARTHOBBYCRAFTER, KNOWLEDGESPORTSMAN, KNOWLEDGEHOBBYCRAFTER
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("INDC", "ARTIST");
        map.put("GNDC", "ARTIST");

        map.put("GODC", "EXPLORER");
        map.put("GOSC", "EXPLORER");
        map.put("IODC", "EXPLORER");
        map.put("IOSC", "EXPLORER");

        map.put("GODA", "SPORTSMAN");
        map.put("IODA", "SPORTSMAN");

        map.put("INSC", "HOBBYCRAFTER");

        map.put("IOSA", "KNOWLEDGESEEKER");
        map.put("GOSA", "KNOWLEDGESEEKER");

        map.put("GNSC", "ARTHOBBYCRAFTER");

        map.put("GNDA", "KNOWLEDGESPORTSMAN");
        map.put("INDA", "KNOWLEDGESPORTSMAN");

        map.put("INSA", "KNOWLEDGEHOBBYCRAFTER");
        map.put("GNSA", "KNOWLEDGEHOBBYCRAFTER");

        String type = map.get(typeInit);

        return HobbyType.valueOf(type);
    }

    private int countTrues(boolean... vars) {
        int count = 0;
        for (boolean var : vars) {
            count += (var ? 1 : 0);
        }
        return count;
    }

    @Transactional
    public PutProfileResponseDto changeMyProfile(Member member, PutProfileRequestDto putProfileRequestDto) {
        member.changeProfile(
                putProfileRequestDto.getUsername(),
                putProfileRequestDto.getPassword(),
                putProfileRequestDto.getNickname(),
                putProfileRequestDto.getProfileImg(),
                putProfileRequestDto.getHobbyType()
        );

        return PutProfileResponseDto.toDto(member);
    }

    public List<SimpleArticleRankResponseDto> getWriteArticles(Member member) {
        List<Article> articles = member.getArticles();
        return articles.stream()
                .map(SimpleArticleRankResponseDto::toDto)
                .collect(Collectors.toList());
    }

    public List<SimpleArticleRankResponseDto> getReplyArticles(Member member) {
        List<Article> articles = member.getReplies().stream()
                .map(r -> r.getArticle())
                .collect(Collectors.toList());

        return articles.stream()
                .map(SimpleArticleRankResponseDto::toDto)
                .collect(Collectors.toList());
    }

    public List<SimpleArticleRankResponseDto> getLikeArticles(Member member) {
        List<Article> articles = member.getArticleLikes().stream()
                .map(al -> al.getArticle())
                .collect(Collectors.toList());

        return articles.stream()
                .map(SimpleArticleRankResponseDto::toDto)
                .collect(Collectors.toList());
    }
}
