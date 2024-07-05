package com.example.hobbytat.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LogoutRequestDto {
    private String sessionId;
}
