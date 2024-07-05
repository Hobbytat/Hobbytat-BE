package com.example.hobbytat.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class PostSignInResponseDto {
    private Boolean isSuccess;
    private int status;
    private String accessToken;
}
