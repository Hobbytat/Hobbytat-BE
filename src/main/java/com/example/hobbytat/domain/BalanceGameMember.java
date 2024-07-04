package com.example.hobbytat.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Builder
public class BalanceGameMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "balance_game_member_id")
    @Setter(value = AccessLevel.NONE)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "balance_game_id")
    private BalanceGame balanceGame;

    @Enumerated(EnumType.STRING)
    private BalanceGameChoice balanceGameChoice;

    public void confirmBalanceGame(BalanceGame balanceGame) {
        this.balanceGame = balanceGame;
        balanceGame.addBalanceGameMember(this);
    }
}
