package com.example.hobbytat.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class PostAnswerResponseDto {
    private Boolean isSuccess;
    private int status;
    private Long memberId;
    private Long questionId;
    private String choice;
}
