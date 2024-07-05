package com.example.hobbytat.controller.dto.response;

import com.example.hobbytat.domain.Reply;
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
    private Long articleId;
    private Long memberId;
    private String content;
    private LocalDateTime createdAt;

    public static PostReplyResponseDto toDto(Reply reply) {
        return PostReplyResponseDto.builder()
                .isSuccess(true)
                .status(200)
                .articleId(reply.getArticle().getId())
                .memberId(reply.getMember().getId())
                .content(reply.getContent())
                .createdAt(reply.getCreatedAt())
                .build();
    }
}

