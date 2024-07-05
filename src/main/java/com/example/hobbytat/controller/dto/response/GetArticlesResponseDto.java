package com.example.hobbytat.controller.dto.response;

import com.example.hobbytat.domain.Article;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
@AllArgsConstructor
public class GetArticlesResponseDto {
    private boolean isSuccess;
    private int status;
    private List<SimpleArticleResponseDto> data;
    private int size;

    public static GetArticlesResponseDto toEntity(List<Article>articleList){
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
