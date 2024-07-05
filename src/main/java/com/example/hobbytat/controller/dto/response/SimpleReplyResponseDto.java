package com.example.hobbytat.controller.dto.response;

import com.example.hobbytat.domain.Reply;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class SimpleReplyResponseDto {
    private Long replyId;
    private Long replyMemberId;
    private String replyMemberName;
    private LocalDateTime replyCreatedAt;
    private String replyContent;

    public static SimpleReplyResponseDto toDto(Reply reply){
        return SimpleReplyResponseDto.builder()
                .replyId(reply.getId())
                .replyMemberId(reply.getMember().getId())
                .replyMemberName(reply.getMember().getNickname())
                .replyCreatedAt(reply.getCreatedAt())
                .replyContent(reply.getContent())
                .build();

    }
}
