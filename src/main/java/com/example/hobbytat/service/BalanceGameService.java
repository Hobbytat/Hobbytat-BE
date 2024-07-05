package com.example.hobbytat.service;

import com.example.hobbytat.domain.*;
import com.example.hobbytat.controller.dto.request.QuestionRequestDto;
import com.example.hobbytat.controller.dto.response.QuestionResultResponseDto;
import com.example.hobbytat.exception.NoSuchEntityException;
import com.example.hobbytat.repository.BalanceGameMemberRepository;
import com.example.hobbytat.repository.BalanceGameRepository;
import com.example.hobbytat.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class BalanceGameService {
    private final BalanceGameRepository balanceGameRepository;
    private final BalanceGameMemberRepository balanceGameMemberRepository;
    private final MemberRepository memberRepository;

    public BalanceGame saveBalanceGame(String title, String firstContent, String secondContent) {
        BalanceGame balanceGame = BalanceGame.builder()
                .title(title)
                .firstContent(firstContent)
                .secondContent(secondContent)
                .build();

        return balanceGameRepository.save(balanceGame);
    }

    public BalanceGame getBalanceGameById(Long id) {
        return balanceGameRepository.findById(id)
                .orElseThrow(() -> new NoSuchEntityException("해당하는 게임이 없습니다."));
    }

    public BalanceGame getRandomBalanceGame(Long memberId) {
        List<BalanceGame> balanceGames = balanceGameRepository.findAll();
        List<BalanceGame> notInvolvedGames = new ArrayList<>();
        for (BalanceGame balanceGame : balanceGames) {
            List<BalanceGameMember> balanceGameMembers = balanceGame.getBalanceGameMembers();
            boolean flag = false;
            for (BalanceGameMember balanceGameMember : balanceGameMembers) {
                if (balanceGameMember.getMember().getId().equals(memberId)) {
                    flag = true;
                }
            }
            if (!flag) {
                notInvolvedGames.add(balanceGame);
            }
        }

        Random random = new Random();
        int randomIndex = random.nextInt(notInvolvedGames.size());

        if (notInvolvedGames.isEmpty())
            throw new NoSuchEntityException("참여하지 않은 게임이 없습니다.");

        return notInvolvedGames.get(randomIndex);
    }

    public BalanceGameMember setAnswer(QuestionRequestDto request, Long questionId, Member member) {

        BalanceGameChoice balanceGameChoice = BalanceGameChoice.valueOf(request.getChoice());


        // BalanceGame을 찾아서 가져오기
        BalanceGame balanceGame = getBalanceGameById(questionId);

        // BalanceGameMember 생성
        BalanceGameMember balanceGameMember = BalanceGameMember.builder()
                .member(member)
                .balanceGameChoice(balanceGameChoice)
                .build();
        balanceGameMember.confirmBalanceGame(balanceGame);

        // BalanceGameMember 저장
        return balanceGameMemberRepository.save(balanceGameMember);
    }

    public QuestionResultResponseDto getQuestionResult(Long balanceGameId) {
        BalanceGame game = balanceGameRepository.findById(balanceGameId)
                .orElseThrow(() -> new NoSuchEntityException("해당하는 게임이 없습니다."));


        long first_val = balanceGameMemberRepository.countByBalanceGameIdAndBalanceGameChoice(balanceGameId, BalanceGameChoice.FIRST);
        long second_val = balanceGameMemberRepository.countByBalanceGameIdAndBalanceGameChoice(balanceGameId, BalanceGameChoice.SECOND);

        long total = first_val + second_val;

        if (total == 0) {
            throw new IllegalArgumentException("No participants in the balance game.");
        }

        Integer firstRatio = (int) ((double) first_val / total * 100);
        Integer secondRatio = (int) ((double) second_val / total * 100);


        return QuestionResultResponseDto.builder()
                .isSuccess(true)
                .status(200)
                .firstContent(game.getFirstContent())
                .firstPercent(firstRatio)
                .secondContent(game.getSecondContent())
                .secondPercent(secondRatio)
                .build();
    }



}
