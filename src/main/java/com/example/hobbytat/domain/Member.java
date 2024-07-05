package com.example.hobbytat.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
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

    @Setter
    private String password;

    private String nickname;

    private String profileImg;

    @Enumerated(EnumType.STRING)
    private HobbyType hobbyType;

    @Enumerated(EnumType.STRING)
    private Role role; //MANAGER, MEMBER

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<Article> articles;

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<ArticleLike> articleLikes;

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<Reply> replies;

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    public void addArticle(Article article) {
        articles.add(article);
    }

    public void addLikes(ArticleLike articleLike) {
        articleLikes.add(articleLike);
    }

    public void addReply(Reply reply) {
        replies.add(reply);
    }

    public void changeProfile(
            String username, String password, String nickname, String profileImg, HobbyType hobbyType
    ) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.profileImg = profileImg;
        this.hobbyType = hobbyType;
    }
}
