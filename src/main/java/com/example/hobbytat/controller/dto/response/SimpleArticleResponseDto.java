package com.example.hobbytat.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class SimpleArticleResponseDto {
    private int articleId;
    private int boardId;
    private int memberId;
    private String title;
    private String content;
    private String img;
    private int viewCount;
    private int likeCount;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
