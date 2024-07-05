package com.example.hobbytat.controller;

import com.example.hobbytat.controller.dto.response.PostLikeResponseDto;
import com.example.hobbytat.security.UserAdaptor;
import com.example.hobbytat.service.LikeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/boards/{boardId}/articles/{articleId}/like")
public class LikeController {
    private final LikeService likeService;

    @PostMapping
    public PostLikeResponseDto postLike(
            @AuthenticationPrincipal UserAdaptor userAdaptor,
            @PathVariable Long articleId) {
        return likeService.postLike(userAdaptor.getMember(), articleId);
    }
}
