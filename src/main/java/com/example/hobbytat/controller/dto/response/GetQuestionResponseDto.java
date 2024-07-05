package com.example.hobbytat.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class GetQuestionResponseDto {
    private Boolean isSuccess;
    private int status;
    private Long questionId;
    private String title;
    private String firstContent;
    private String secondContent;
}
