package com.example.hobbytat.controller.dto.response;

import com.example.hobbytat.domain.Article;
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
    private Long articleId;
    private Long boardId;
    private Long memberId;
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

    public static GetArticleByIdResponseDto toDto(Article article) {
        List<SimpleReplyResponseDto> simpleReplyResponseDtos = article.getReplies().stream().map(SimpleReplyResponseDto::toDto).toList();

        return GetArticleByIdResponseDto.builder()
                .articleId(article.getId())
                .boardId(builder().boardId)
                .memberId(article.getMember().getId())
                .title(article.getTitle())
                .content(article.getContent())
                .img(article.getImg())
                .likeCount(article.getLikeCount())
                .viewCount(article.getViewCount())
                .replyCount(article.getReplyCount())
                .replies(simpleReplyResponseDtos)
                //TODO 처리가 필요하다
                //.isMemberLike(article.getArticleLikes())
                .createdAt(article.getCreatedAt())
                .modifiedAt(article.getModifiedAt())
                .build();

    }
}
