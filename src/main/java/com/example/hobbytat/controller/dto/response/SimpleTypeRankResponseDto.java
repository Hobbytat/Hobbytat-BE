package com.example.hobbytat.controller.dto.response;

import com.example.hobbytat.domain.HobbyType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
@AllArgsConstructor
public class SimpleTypeRankResponseDto {
    private HobbyType hobbyType;

    @Setter
    private int rank;

    private int percent;
}
