package com.example.hobbytat.controller.dto.request;

import com.example.hobbytat.domain.HobbyType;
import com.example.hobbytat.domain.Member;
import com.example.hobbytat.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SignUpRequestDto {
    private String username;
    private String password;
    private String nickname;
    private String profileImg;
    private HobbyType hobbyType;

    public Member toEntity() {
        return Member.builder()
                .username(username)
                .password(password)
                .nickname(nickname)
                .profileImg(profileImg)
                .hobbyType(hobbyType)
                .role(Role.MEMBER)
                .build();
    }
}
