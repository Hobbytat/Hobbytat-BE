package com.example.hobbytat.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class PostLikeResponseDto {
    private boolean isSuccess;
    private int status;
}

