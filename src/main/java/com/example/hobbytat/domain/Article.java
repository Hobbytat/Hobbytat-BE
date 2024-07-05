package com.example.hobbytat.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Builder
public class Article extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_id")
    @Setter(value = AccessLevel.NONE)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board board;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private String title;
    private String content;
    private String img; // Image URL
    @Builder.Default
    private int viewCount = 0;
    @Builder.Default
    private int likeCount = 0;
    @Builder.Default
    private int replyCount = 0;

    @OneToMany(mappedBy = "article", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<ArticleLike> articleLikes;

    @OneToMany(mappedBy = "article", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Reply> replies;

    public void confirmBoard(Board board) {
        this.board = board;
        board.addArticle(this);
    }

    public void confirmMember(Member member) {
        this.member = member;
        member.addArticle(this);
    }

    public void addViewCount() {
        this.viewCount += 1;
    }

    public void addReply(Reply reply) {
        replies.add(reply);
    }

    public void addLikes(ArticleLike articleLike) {
        articleLikes.add(articleLike);
    }

    public void addReplyCount() {
        this.replyCount += 1;
    }
}
