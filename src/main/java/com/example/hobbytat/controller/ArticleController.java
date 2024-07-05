package com.example.hobbytat.controller;

import com.example.hobbytat.controller.dto.request.PostArticleRequestDto;
import com.example.hobbytat.controller.dto.response.DeleteArticleResponseDto;
import com.example.hobbytat.controller.dto.response.GetArticlesResponseDto;
import com.example.hobbytat.controller.dto.response.PostArticleResponseDto;
import com.example.hobbytat.domain.Article;
import com.example.hobbytat.domain.Board;
import com.example.hobbytat.service.ArticleService;
import com.example.hobbytat.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/boards/")
public class ArticleController {

    public final ArticleService articleService;
    public final BoardService boardService;

    @PostMapping("{boardId}/articles")
    public PostArticleResponseDto postArticle(@PathVariable("boardId")Long boardId, @RequestBody PostArticleRequestDto postArticleRequestDto){
        Board board = boardService.getBoardById(boardId);
        //TODO member 연관관계 처리 필요
        Article article = postArticleRequestDto.toEntity(board);
        Article save = articleService.save(article);
        return PostArticleResponseDto.toDto(save);
    }

    @DeleteMapping("{boardId}/articles/{articleId}")
    public DeleteArticleResponseDto deleteArticle(@PathVariable("boardId")Long boardId, @PathVariable("articleId")Long articleId){
        if(articleService.deleteById(articleId)){
            return DeleteArticleResponseDto.builder()
                    .isSuccess(true)
                    .status(200)
                    .build();
        }
        else
            throw new RuntimeException();
    }

    //TODO 기본으로 몇개 가져오지?
    @GetMapping("/{boardId}/articles")
    public GetArticlesResponseDto getArticleById(@PathVariable("boardId")Long boardId,
                                                 @RequestParam(value = "article_id", defaultValue = "10")Long articleId){
        List<Article> article = articleService.getArticleById(boardId);
        return GetArticlesResponseDto.toEntity(article);
    }
}
