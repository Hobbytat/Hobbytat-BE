package com.example.hobbytat.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class GetArticlesRankingResponseDto {
    private Boolean isSuccess;
    private int status;
    private List<SimpleArticleRankResponseDto> data;
    private int size;
}
