package com.example.hobbytat.repository;

import com.example.hobbytat.domain.BalanceGame;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BalanceGameRepository extends JpaRepository<BalanceGame, Long> {
}
