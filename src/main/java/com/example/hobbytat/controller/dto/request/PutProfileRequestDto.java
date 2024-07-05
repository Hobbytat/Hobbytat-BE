package com.example.hobbytat.controller.dto.request;

import com.example.hobbytat.domain.HobbyType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PutProfileRequestDto {
    private String username;
    private String password;
    private String nickname;
    private String profileImg;
    private HobbyType hobbyType;
}
