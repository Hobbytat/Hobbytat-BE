package com.example.hobbytat.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class PostAnswerResponseDto {
    private boolean isSuccess;
    private int status;
    private Long memberId;
    private Long questionId;
    private String choice;
}
