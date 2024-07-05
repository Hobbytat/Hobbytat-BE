package com.example.hobbytat.controller.dto.response;

import com.example.hobbytat.domain.HobbyType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class GetHobbyTypeResponseDto {
    private Boolean isSuccess;
    private int status;
    private HobbyType hobbyType;
}

