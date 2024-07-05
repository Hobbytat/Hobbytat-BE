package com.example.hobbytat.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostArticleRequestDto {
    private int memberId;
    private String title;
    private String content;
    private String img;
}
