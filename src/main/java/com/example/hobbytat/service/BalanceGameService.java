package com.example.hobbytat.service;

import com.example.hobbytat.domain.*;
import com.example.hobbytat.model.QuestionRequest;
import com.example.hobbytat.model.QuestionResult;
import com.example.hobbytat.repository.BalanceGameMemberRepository;
import com.example.hobbytat.repository.BalanceGameRepository;
import com.example.hobbytat.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class BalanceGameService {

    @Autowired
    private BalanceGameRepository balanceGameRepository;

    @Autowired
    private BalanceGameMemberRepository balanceGameMemberRepository;

    @Autowired
    private MemberRepository memberRepository;

    public BalanceGame saveBalanceGame(String title, String firstContent, String secondContent) {
        BalanceGame balanceGame = BalanceGame.builder()
                .title(title)
                .firstContent(firstContent)
                .secondContent(secondContent)
                .build();

        return balanceGameRepository.save(balanceGame);
    }

    public Optional<BalanceGame> getBalanceGameById(Long id) {
        return balanceGameRepository.findById(id);
    }

    public boolean setAnswer(QuestionRequest request) {

        BalanceGameChoice balanceGameChoice = BalanceGameChoice.valueOf(request.getChoice());

        // Member를 찾아서 가져오기
        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new NoSuchElementException("해당하는 멤버가 없습니다."));
        if(member == null){
            return false;
        }

        // BalanceGame을 찾아서 가져오기
        Optional<BalanceGame> findBalanceGame = balanceGameRepository.findById(request.getQuestionId());

        BalanceGame balanceGame = findBalanceGame.get();
        if(balanceGame == null){
            return false;
        }
        // BalanceGameMember 생성
        BalanceGameMember balanceGameMember = BalanceGameMember.builder()
                .member(member)
                .balanceGameChoice(balanceGameChoice)
                .build();
        balanceGameMember.confirmBalanceGame(balanceGame);

        // BalanceGameMember 저장
        balanceGameMemberRepository.save(balanceGameMember);
        return true;
    }

    public QuestionResult getQuestionResult(Long balanceGameId) {
        Optional<BalanceGame> findGame = balanceGameRepository.findById(balanceGameId);
        BalanceGame game = findGame.get();


        long first_val = balanceGameMemberRepository.countByBalanceGameIdAndBalanceGameChoice(balanceGameId, BalanceGameChoice.FIRST);
        long second_val = balanceGameMemberRepository.countByBalanceGameIdAndBalanceGameChoice(balanceGameId, BalanceGameChoice.SECOND);

        long total = first_val + second_val;

        if (total == 0) {
            throw new IllegalArgumentException("No participants in the balance game.");
        }

        Integer first_ratio = (int) ((double) first_val / total * 100);
        Integer second_ratio = (int) ((double) second_val / total * 100);


        return new QuestionResult(true, 200, game.getFirstContent(), (Integer) first_ratio, game.getSecondContent(), second_ratio);
    }



}
