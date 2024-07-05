package com.example.hobbytat.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Builder
public class BalanceGame extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "balance_game_id")
    @Setter(value = AccessLevel.NONE)
    private Long id;

    private String title;

    private String firstContent;
    private String secondContent;

    @OneToMany(mappedBy = "balanceGame", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<BalanceGameMember> balanceGameMembers;

    public void addBalanceGameMember(BalanceGameMember balanceGameMember) {
        balanceGameMembers.add(balanceGameMember);
    }
}
