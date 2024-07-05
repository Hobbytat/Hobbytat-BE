package com.example.hobbytat.repository;

import com.example.hobbytat.domain.BalanceGameChoice;
import com.example.hobbytat.domain.BalanceGameMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BalanceGameMemberRepository extends JpaRepository<BalanceGameMember, Long> {
    long countByBalanceGameIdAndBalanceGameChoice(Long balanceGameId, BalanceGameChoice balanceGameChoice);
}
