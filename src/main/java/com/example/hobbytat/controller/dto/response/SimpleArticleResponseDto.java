package com.example.hobbytat.controller.dto.response;

import com.example.hobbytat.domain.Article;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class SimpleArticleResponseDto {
    private Long articleId;
    private Long boardId;
    private Long memberId;
    private String member_nickname;
    private String title;
    private String content;
    private String img;
    private int viewCount;
    private int likeCount;
    private int replyCount;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public static SimpleArticleResponseDto toDto(Article article){
        return SimpleArticleResponseDto.builder()
                .articleId(article.getId())
                .boardId(article.getBoard().getId())
                .memberId(article.getMember().getId())
                .member_nickname(article.getMember().getNickname())
                .title(article.getTitle())
                .content(article.getContent())
                .img(article.getImg())
                .viewCount(article.getViewCount())
                .replyCount(article.getReplyCount())
                .createdAt(article.getCreatedAt())
                .modifiedAt(article.getModifiedAt())
                .build();
    }
}
