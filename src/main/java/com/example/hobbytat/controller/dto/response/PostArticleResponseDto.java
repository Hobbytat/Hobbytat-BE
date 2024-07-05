package com.example.hobbytat.controller.dto.response;

import com.example.hobbytat.domain.Article;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class PostArticleResponseDto {
    private Boolean isSuccess;
    private int status;
    private Long articleId;
    private Long boardId;
    private int memberId;
    private String title;
    private String content;
    private String img;
    private LocalDateTime createdAt;

    //TODO member 처리 필요
    public static PostArticleResponseDto toDto(Article article){
        return PostArticleResponseDto.builder()
                .isSuccess(true)
                .status(200)
                .articleId(article.getId())
                .boardId(article.getBoard().getId())
                .title(article.getTitle())
                .content(article.getContent())
                .img(article.getImg())
                .createdAt(article.getCreatedAt())
                .build();


    }
}
