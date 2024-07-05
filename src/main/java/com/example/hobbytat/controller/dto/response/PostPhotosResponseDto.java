package com.example.hobbytat.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class PostPhotosResponseDto {
    private boolean isSuccess;
    private int status;
    private List<UrlDto> urls;

}
