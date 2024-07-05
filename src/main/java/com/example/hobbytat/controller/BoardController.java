package com.example.hobbytat.controller;

import com.example.hobbytat.controller.dto.response.GetBoardsResponseDto;
import com.example.hobbytat.domain.Board;
import com.example.hobbytat.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/boards")
public class BoardController {

    private final BoardService boardService;

    @GetMapping()
    public GetBoardsResponseDto getBoard(){
        return GetBoardsResponseDto.toDto(boardService.getBoards());
    }

}
