package com.example.hobbytat.repository;

import com.example.hobbytat.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByUsername(String username);

    boolean existsByNickname(String nickname);

    boolean existsByUsername(String username);
}
