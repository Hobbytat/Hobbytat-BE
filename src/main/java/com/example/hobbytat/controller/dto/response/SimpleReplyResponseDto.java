package com.example.hobbytat.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class SimpleReplyResponseDto {
    private int replyId;
    private int replyMemberId;
    private String replyMemberName;
    private LocalDateTime replyCreatedAt;
    private String replyContent;
}
