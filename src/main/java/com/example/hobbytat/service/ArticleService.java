package com.example.hobbytat.service;

import com.example.hobbytat.domain.Article;
import com.example.hobbytat.domain.Board;
import com.example.hobbytat.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    @Transactional
    public Article save(Article article){
        return articleRepository.save(article);
    }

    @Transactional
    public Boolean deleteById(Long articleId){

        articleRepository.findById(articleId);
        articleRepository.deleteById(articleId);
        //TODO 하나의 트랜잭션에서 관리되는게 맞는가?
        return true;
    }
}
