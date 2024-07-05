package com.example.hobbytat.controller.dto.response;

import com.example.hobbytat.domain.HobbyType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class GetProfileResponseDto {
    private boolean isSuccess;
    private int status;
    private int memberId;
    private String username;
    private String password;
    private String nickname;
    private String profileImg;
    private HobbyType hobbyType;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
