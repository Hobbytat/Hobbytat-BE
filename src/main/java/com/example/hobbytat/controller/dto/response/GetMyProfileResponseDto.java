package com.example.hobbytat.controller.dto.response;

import com.example.hobbytat.domain.HobbyType;
import com.example.hobbytat.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class GetMyProfileResponseDto {
    private Boolean isSuccess;
    private int status;
    private Long memberId;
    private String username;
    private String password;
    private String nickname;
    private String profileImg;
    private HobbyType hobbyType;
    private String hobbyDescription;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    private List<SimpleArticleRankResponseDto> writeArticles;
    private int writeArticleSize;

    private List<SimpleArticleRankResponseDto> replyArticles;
    private int replyArticleSize;

    private List<SimpleArticleRankResponseDto> likeArticles;
    private int likeArticleSize;

    public void setWriteArticles(List<SimpleArticleRankResponseDto> writeArticles) {
        this.writeArticles = writeArticles;
        writeArticleSize = writeArticles.size();
    }

    public void setReplyArticles(List<SimpleArticleRankResponseDto> replyArticles) {
        this.replyArticles = replyArticles;
        replyArticleSize = replyArticles.size();
    }

    public void setLikeArticles(List<SimpleArticleRankResponseDto> likeArticles) {
        this.likeArticles = likeArticles;
        likeArticleSize = likeArticles.size();
    }

    public static GetMyProfileResponseDto toDto(Member member) {
        return GetMyProfileResponseDto.builder()
                .isSuccess(true)
                .status(200)
                .memberId(member.getId())
                .username(member.getUsername())
                .password(member.getPassword())
                .nickname(member.getNickname())
                .profileImg(member.getProfileImg())
                .hobbyType(member.getHobbyType())
                .hobbyDescription(member.getHobbyType().getDescription())
                .createdAt(member.getCreatedAt())
                .modifiedAt(member.getModifiedAt())
                .build();
    }
}
