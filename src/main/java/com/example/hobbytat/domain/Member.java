package com.example.hobbytat.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Builder
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    @Setter(value = AccessLevel.NONE)
    private Long id;

    private String username;
    private String password;

    private String nickname;

    private String profileImg;

    @Enumerated(EnumType.STRING)
    private HobbyType hobbyType;

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<Article> articles;

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<ArticleLike> articleLikes;

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<Reply> replies;

    public void addArticle(Article article) {
        articles.add(article);
    }

    public void addLikes(ArticleLike articleLike) {
        articleLikes.add(articleLike);
    }

    public void addReply(Reply reply) {
        replies.add(reply);
    }
}
