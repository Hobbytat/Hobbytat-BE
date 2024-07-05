package com.example.hobbytat.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class GetArticleByIdResponseDto {
    private boolean isSuccess;
    private int status;
    private int articleId;
    private int boardId;
    private int memberId;
    private String title;
    private String content;
    private String img;
    private int likeCount;
    private int viewCount;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
