package com.example.hobbytat.service;

import com.example.hobbytat.controller.dto.response.DeleteReplyResponseDto;
import com.example.hobbytat.controller.dto.response.PostLikeResponseDto;
import com.example.hobbytat.domain.Article;
import com.example.hobbytat.domain.ArticleLike;
import com.example.hobbytat.domain.Member;
import com.example.hobbytat.repository.ArticleLikeRepository;
import com.example.hobbytat.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LikeService {
    private final ArticleLikeRepository articleLikeRepository;
    private final ArticleRepository articleRepository;

    private Article findArticleByArticleId(Long articleId) {
        return articleRepository.findById(articleId)
                .orElseThrow(() -> new NoSuchElementException("해당 게시글이 존재하지 않습니다."));
    }

    @Transactional
    public PostLikeResponseDto postLike(Member member, Long articleId) {
        Optional<ArticleLike> articleLike = articleLikeRepository.findByMemberIdAndArticleId(member.getId(), articleId);

        if (articleLike.isPresent()) {
            articleLikeRepository.delete(articleLike.get());
        } else {
            Article article = findArticleByArticleId(articleId);

            ArticleLike articleLikeEntity = ArticleLike.builder().build();
            articleLikeEntity.confirmArticle(article);
            articleLikeEntity.confirmMember(member);

            articleLikeRepository.save(articleLikeEntity);
        }

        return PostLikeResponseDto.builder()
                .status(200)
                .isSuccess(true)
                .build();
    }
}
