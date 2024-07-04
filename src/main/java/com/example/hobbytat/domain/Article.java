package com.example.hobbytat.domain;

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
    private int viewCount = 0;
    private int likeCount = 0;

    @OneToMany(mappedBy = "article", fetch = FetchType.LAZY)
    private List<ArticleLike> articleLikes;

    public void confirmBoard(Board board) {
        this.board = board;
        board.addArticle(this);
    }

    public void confirmMember(Member member) {
        this.member = member;
        member.addArticle(this);
    }

    public void addLikes(ArticleLike articleLike) {
        articleLikes.add(articleLike);
    }
}