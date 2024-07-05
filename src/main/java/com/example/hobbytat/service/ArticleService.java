package com.example.hobbytat.service;

import com.example.hobbytat.domain.Article;
import com.example.hobbytat.domain.Board;
import com.example.hobbytat.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    @Transactional
    public Article save(Article article){
        return articleRepository.save(article);
    }
}
