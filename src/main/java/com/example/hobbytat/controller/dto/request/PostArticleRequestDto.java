package com.example.hobbytat.controller.dto.request;

import com.example.hobbytat.domain.Article;
import com.example.hobbytat.domain.Board;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostArticleRequestDto {
    private int memberId;
    private String title;
    private String content;
    private String img;

    //TODO member 추가
    public Article toEntity(Board board){
        return Article.builder()
                .board(board)
                .title(this.title)
                .content(this.content)
                .img(this.img)
                .build();
    }

}
