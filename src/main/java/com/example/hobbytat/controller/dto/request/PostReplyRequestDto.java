package com.example.hobbytat.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostReplyRequestDto {
    private int memberId;
    private String content;
}
