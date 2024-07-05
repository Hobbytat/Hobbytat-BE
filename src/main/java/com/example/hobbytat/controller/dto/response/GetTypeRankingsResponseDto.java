package com.example.hobbytat.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class GetTypeRankingsResponseDto {
    private boolean isSuccess;
    private int status;
    private List<SimpleTypeRankResponseDto> data;
    private int size;
}
