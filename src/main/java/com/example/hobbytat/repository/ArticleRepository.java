package com.example.hobbytat.repository;

import com.example.hobbytat.domain.Article;
import com.example.hobbytat.domain.ArticleLike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
