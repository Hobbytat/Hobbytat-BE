package com.example.hobbytat.service;

import com.example.hobbytat.domain.Board;
import com.example.hobbytat.domain.HobbyType;
import com.example.hobbytat.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public List<Board> getBoards(){
        return boardRepository.findAll();
    }

    public Board getBoardById(Long boardID){
       return boardRepository.findById(boardID).get();
    }

}
