package com.example.hobbytat.controller;

import com.example.hobbytat.controller.dto.request.PostArticleRequestDto;
import com.example.hobbytat.controller.dto.response.DeleteArticleResponseDto;
import com.example.hobbytat.controller.dto.response.GetArticleByIdResponseDto;
import com.example.hobbytat.controller.dto.response.GetArticlesResponseDto;
import com.example.hobbytat.controller.dto.response.PostArticleResponseDto;
import com.example.hobbytat.domain.Article;
import com.example.hobbytat.domain.Board;
import com.example.hobbytat.domain.Member;
import com.example.hobbytat.security.UserAdaptor;
import com.example.hobbytat.service.ArticleService;
import com.example.hobbytat.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/boards/")
public class ArticleController {

    public final ArticleService articleService;
    public final BoardService boardService;

    @PostMapping("{boardId}/articles")
    public PostArticleResponseDto postArticle(@PathVariable("boardId")Long boardId,
                                              @RequestBody PostArticleRequestDto postArticleRequestDto,
                                              @AuthenticationPrincipal UserAdaptor userAdaptor){
        Board board = boardService.getBoardById(boardId);
        Member member =userAdaptor.getMember();
        Article article = postArticleRequestDto.toEntity(board,member);
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
    public GetArticlesResponseDto getArticleByBoardId(@PathVariable("boardId")Long boardId,
                                                 @RequestParam(value = "article_id", defaultValue = "10")Long articleId){
        List<Article> article = articleService.getArticleByBoardId(boardId);
        return GetArticlesResponseDto.toDto(article);
    }

    @GetMapping("/{boardId}/articles/{articleId}")
    public GetArticleByIdResponseDto getArticleById(@PathVariable("boardId")Long boardId,
                                                    @PathVariable("articleId")Long articleId){
        Article article = articleService.getArticleById(articleId);
        return GetArticleByIdResponseDto.toDto(article);
    }
}
