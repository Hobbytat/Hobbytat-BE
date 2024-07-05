package com.example.hobbytat.controller.dto.response;

import com.example.hobbytat.domain.HobbyType;
import com.example.hobbytat.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class PostSignUpResponseDto {
    private Boolean isSuccess;
    private int status;
    private Long memberId;
    private String username;
    private String password;
    private String nickname;
    private String profileImg;
    private HobbyType hobbyType;
    private LocalDateTime createdAt;

    public static PostSignUpResponseDto toDto(Member member) {
        return PostSignUpResponseDto.builder()
                .isSuccess(true)
                .status(200)
                .memberId(member.getId())
                .username(member.getUsername())
                .password(member.getPassword())
                .nickname(member.getNickname())
                .profileImg(member.getProfileImg())
                .hobbyType(member.getHobbyType())
                .createdAt(member.getCreatedAt())
                .build();
    }
}
