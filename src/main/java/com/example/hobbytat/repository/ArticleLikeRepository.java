package com.example.hobbytat.repository;

import com.example.hobbytat.domain.ArticleLike;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArticleLikeRepository extends JpaRepository<ArticleLike, Long> {
    Optional<ArticleLike> findByMemberIdAndArticleId(Long memberId, Long articleId);
}
