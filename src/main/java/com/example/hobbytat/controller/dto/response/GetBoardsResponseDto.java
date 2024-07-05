package com.example.hobbytat.controller.dto.response;

import com.example.hobbytat.domain.Board;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
@AllArgsConstructor
public class GetBoardsResponseDto {
    private Boolean isSuccess;
    private int status;
    private List<SimpleBoardResponseDto> data;
    private int size;

    public static GetBoardsResponseDto toDto(List<Board> boardList){
        List<SimpleBoardResponseDto> collect = boardList.stream().map(SimpleBoardResponseDto::toDto)
                .collect(Collectors.toList());

        return GetBoardsResponseDto.builder()
                .isSuccess(true)
                .status(200)
                .data(collect)
                .size(collect.size())
                .build();
    }
}
