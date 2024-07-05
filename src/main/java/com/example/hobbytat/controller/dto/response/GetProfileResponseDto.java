package com.example.hobbytat.controller.dto.response;

import com.example.hobbytat.domain.HobbyType;
import com.example.hobbytat.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class GetProfileResponseDto {
    private boolean isSuccess;
    private int status;
    private Long memberId;
    private String nickname;
    private String profileImg;
    private HobbyType hobbyType;

    public static GetProfileResponseDto toDto(Member member) {
        return GetProfileResponseDto.builder()
                .isSuccess(true)
                .status(200)
                .memberId(member.getId())
                .nickname(member.getNickname())
                .profileImg(member.getProfileImg())
                .hobbyType(member.getHobbyType())
                .build();
    }
}
