package com.example.hobbytat.repository;

import com.example.hobbytat.domain.BalanceGameMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BalanceGameMemberRepository extends JpaRepository<BalanceGameMember, Long> {
}
