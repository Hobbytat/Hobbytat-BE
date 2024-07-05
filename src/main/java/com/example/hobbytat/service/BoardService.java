package com.example.hobbytat.service;

import com.example.hobbytat.domain.Board;
import com.example.hobbytat.domain.HobbyType;
import com.example.hobbytat.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public List<Board> getBoards(){
        return boardRepository.findAll();
    }

}
