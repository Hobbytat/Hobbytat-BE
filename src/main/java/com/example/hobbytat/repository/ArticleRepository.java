package com.example.hobbytat.repository;

import com.example.hobbytat.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findTop5ByOrderByViewCountDesc();


}
