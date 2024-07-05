package com.example.hobbytat.service;

import com.example.hobbytat.controller.dto.response.DeleteReplyResponseDto;
import com.example.hobbytat.controller.dto.response.PostReplyResponseDto;
import com.example.hobbytat.domain.Article;
import com.example.hobbytat.domain.Member;
import com.example.hobbytat.domain.Reply;
import com.example.hobbytat.repository.ArticleRepository;
import com.example.hobbytat.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReplyService {
    private final ReplyRepository replyRepository;
    private final ArticleRepository articleRepository;

    public PostReplyResponseDto postReply(Member member, String content, Long articleId) {
        Article article = findArticleByArticleId(articleId);
        Reply reply = Reply.builder().content(content).build();
        reply.confirmMember(member);
        reply.confirmArticle(article);

        replyRepository.save(reply);

        return PostReplyResponseDto.toDto(reply);
    }

    private Article findArticleByArticleId(Long articleId) {
        return articleRepository.findById(articleId)
                .orElseThrow(() -> new NoSuchElementException("해당 게시글이 존재하지 않습니다."));
    }

    public DeleteReplyResponseDto deleteReply(Long replyId) {
        replyRepository.deleteById(replyId);

        return DeleteReplyResponseDto.builder()
                .status(200)
                .isSuccess(true)
                .build();
    }
}
