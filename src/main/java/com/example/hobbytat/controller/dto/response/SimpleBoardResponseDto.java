package com.example.hobbytat.controller.dto.response;

import com.example.hobbytat.domain.Board;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class SimpleBoardResponseDto {
    private Long boardId;
    private String title;
    private String img;

    public static SimpleBoardResponseDto toDto(Board board){
        return SimpleBoardResponseDto.builder()
                .boardId(board.getId())
                .title(board.getTitle())
                .img(board.getImg())
                .build();
    }
}
