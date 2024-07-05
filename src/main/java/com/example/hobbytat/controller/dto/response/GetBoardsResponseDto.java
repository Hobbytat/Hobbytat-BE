package com.example.hobbytat.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class GetBoardsResponseDto {
    private boolean isSuccess;
    private int status;
    private List<SimpleBoardResponseDto> data;
    private int size;
}
