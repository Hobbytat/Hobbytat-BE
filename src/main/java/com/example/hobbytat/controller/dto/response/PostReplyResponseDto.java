package com.example.hobbytat.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class PostReplyResponseDto {
    private boolean isSuccess;
    private int status;
    private int articleId;
    private int memberId;
    private String content;
    private LocalDateTime createdAt;
}

