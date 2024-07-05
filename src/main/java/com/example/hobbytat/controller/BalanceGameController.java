package com.example.hobbytat.controller;

import com.example.hobbytat.domain.BalanceGame;
import com.example.hobbytat.domain.BalanceGameChoice;
import com.example.hobbytat.domain.BalanceGameMember;
import com.example.hobbytat.model.QuestionRequest;
import com.example.hobbytat.model.QuestionResult;
import com.example.hobbytat.service.BalanceGameService;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/game")
public class BalanceGameController {

    @Autowired
    private BalanceGameService balanceGameService;

    @GetMapping("/questions")
    public QuestionResult getTotalQuestion(@RequestBody QuestionRequest questionResult){
        Long questionId = questionResult.getQuestionId();
        QuestionResult questionResults = balanceGameService.getQuestionResult(questionId);
        return questionResults;
    }




    @GetMapping("/questions/{questionId}")
    public ResponseEntity<SuccessResponse> getQuestion(@PathVariable Long questionId) {
        Optional<BalanceGame> findGame = balanceGameService.getBalanceGameById(questionId);


        if (findGame.isPresent()) {
            BalanceGame balanceGame = findGame.get();
            SuccessResponse response = new SuccessResponse(true, 200, questionId.intValue(), balanceGame.getTitle(), balanceGame.getFirstContent(), balanceGame.getSecondContent());
            return ResponseEntity.ok(response);
        } else {
            throw new ResourceNotFoundException("해당하는 질문이 없습니다.");
        }
    }

    @PostMapping("/questions/answers")
    public ResponseEntity<PostResponse> postQuestion(@RequestBody QuestionRequest request){

        if(balanceGameService.setAnswer(request)){
            PostResponse response = new PostResponse(true, 200, request.getMemberId(), request.getQuestionId(), request.getChoice());
            return ResponseEntity.ok(response);
        };
        throw new ResourceNotFoundException("해당하는 질문이 없습니다.");
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SuccessResponse {
        private boolean isSuccess;
        private int status;
        private Integer questionId;
        private String title;
        private String firstContent;
        private String secondContent;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ErrorResponse {
        private boolean isSuccess;
        private int status;
        private String errorMessage;
    }

    @Data
    @AllArgsConstructor
    public static class AnswerResponse {
        private boolean isSuccess;
        private int status;
        private Integer memberId;
        private Integer questionId;
        private String choice;
    }

    @Data
    @AllArgsConstructor
    public static class PostResponse {
        private boolean isSuccess;
        private int status;
        private Long memberId;
        private Long questionId;
        private String choice;
    }



    @ResponseStatus(HttpStatus.NOT_FOUND)
    public class ResourceNotFoundException extends RuntimeException {
        public ResourceNotFoundException(String message) {
            super(message);
        }
    }
}
