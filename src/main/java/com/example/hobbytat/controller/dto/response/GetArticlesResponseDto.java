package com.example.hobbytat.controller.dto.response;

import com.example.hobbytat.domain.Article;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class GetArticlesResponseDto {
    private Boolean isSuccess;
    private int status;
    private List<SimpleArticleResponseDto> data;
    private int size;

    public static GetArticlesResponseDto toDto(List<Article>articleList){
        List<SimpleArticleResponseDto> collect = articleList.stream().map(SimpleArticleResponseDto::toDto)
                .toList();
        return GetArticlesResponseDto.builder()
                .isSuccess(true)
                .status(200)
                .data(collect)
                .size(collect.size())
                .build();

    }
}
