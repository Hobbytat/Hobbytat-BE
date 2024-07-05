package com.example.hobbytat.controller;

import com.example.hobbytat.controller.dto.request.PostQuestionRequestDto;
import com.example.hobbytat.controller.dto.response.GetQuestionResponseDto;
import com.example.hobbytat.controller.dto.response.PostAnswerResponseDto;
import com.example.hobbytat.domain.BalanceGame;
import com.example.hobbytat.controller.dto.request.QuestionRequestDto;
import com.example.hobbytat.controller.dto.response.QuestionResultResponseDto;
import com.example.hobbytat.domain.BalanceGameMember;
import com.example.hobbytat.security.UserAdaptor;
import com.example.hobbytat.service.BalanceGameService;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/game")
public class BalanceGameController {

    private final BalanceGameService balanceGameService;

    @GetMapping("/questions/{questionId}")
    public QuestionResultResponseDto getTotalQuestion(@PathVariable Long questionId){
        QuestionResultResponseDto questionResultsResponseDto = balanceGameService.getQuestionResult(questionId);

        return questionResultsResponseDto;
    }


    @GetMapping("/questions")
    public GetQuestionResponseDto getQuestion(@AuthenticationPrincipal UserAdaptor userAdaptor) {
        BalanceGame findBalanceGame = balanceGameService.getRandomBalanceGame(userAdaptor.getMember().getId());

        return GetQuestionResponseDto.builder()
                .isSuccess(true)
                .status(200)
                .questionId(findBalanceGame.getId())
                .title(findBalanceGame.getTitle())
                .firstContent(findBalanceGame.getFirstContent())
                .secondContent(findBalanceGame.getSecondContent())
                .build();
    }

    @PostMapping("/questions/{questionId}/answers")
    public PostAnswerResponseDto postAnswers(
            @AuthenticationPrincipal UserAdaptor userAdaptor,
            @RequestBody QuestionRequestDto request,
            @PathVariable Long questionId){
        BalanceGameMember balanceGameMember = balanceGameService.setAnswer(request, questionId, userAdaptor.getMember());

        return PostAnswerResponseDto.builder()
                .isSuccess(true)
                .status(200)
                .memberId(balanceGameMember.getMember().getId())
                .questionId(balanceGameMember.getBalanceGame().getId())
                .choice(balanceGameMember.getBalanceGameChoice().toString())
                .build();
    }

    @PostMapping("/questions")
    public boolean postQuestion(@RequestBody PostQuestionRequestDto requestDto) {
        balanceGameService.saveBalanceGame(requestDto.getTitle(), requestDto.getFirstContent(), requestDto.getSecondContent());
        return true;
    }

}
