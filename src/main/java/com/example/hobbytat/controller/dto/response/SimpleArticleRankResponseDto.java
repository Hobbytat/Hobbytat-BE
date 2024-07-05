package com.example.hobbytat.controller.dto.response;

import com.example.hobbytat.domain.Article;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class SimpleArticleRankResponseDto {
    private Long articleId;
    private String articleTitle;
    private String boardTitle;
    private String memberName;
    private int viewCount;
    private int replyCount;

    public static SimpleArticleRankResponseDto toDto(Article article) {
        return SimpleArticleRankResponseDto.builder()
                .articleId(article.getId())
                .articleTitle(article.getTitle())
                .boardTitle(article.getBoard().getTitle())
                .memberName(article.getMember().getNickname())
                .viewCount(article.getViewCount())
                .replyCount(article.getReplies().size())
                .build();
    }
}
