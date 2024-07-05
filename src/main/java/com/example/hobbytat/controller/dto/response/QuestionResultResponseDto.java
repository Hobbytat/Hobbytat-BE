package com.example.hobbytat.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
@AllArgsConstructor
public class QuestionResultResponseDto {

    private boolean isSuccess;
    private int status;
    private String firstContent;
    private Integer firstPercent;
    private String secondContent;
    private Integer secondPercent;
}
