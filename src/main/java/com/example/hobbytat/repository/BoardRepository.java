package com.example.hobbytat.repository;

import com.example.hobbytat.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
