package com.example.hobbytat.repository;

import com.example.hobbytat.domain.BalanceGame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BalanceGameRepository extends JpaRepository<BalanceGame, Long> {
}
