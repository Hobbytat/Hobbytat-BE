package com.example.hobbytat.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

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
    private int replyCount;
    private List<SimpleReplyResponseDto> replies;
    private boolean isMemberLike; // 좋아요 여부
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
