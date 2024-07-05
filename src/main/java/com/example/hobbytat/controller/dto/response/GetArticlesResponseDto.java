package com.example.hobbytat.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class GetArticlesResponseDto {
    private boolean isSuccess;
    private int status;
    private List<SimpleArticleResponseDto> data;
    private int size;
}
