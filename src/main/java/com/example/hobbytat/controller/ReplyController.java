package com.example.hobbytat.controller;

import com.example.hobbytat.controller.dto.request.PostReplyRequestDto;
import com.example.hobbytat.controller.dto.response.DeleteReplyResponseDto;
import com.example.hobbytat.controller.dto.response.PostReplyResponseDto;
import com.example.hobbytat.security.UserAdaptor;
import com.example.hobbytat.service.ReplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/boards/{boardId}/articles/{articleId}/replies")
public class ReplyController {
    private final ReplyService replyService;

    @PostMapping
    public PostReplyResponseDto postReply(
            @AuthenticationPrincipal UserAdaptor userAdaptor,
            @RequestBody PostReplyRequestDto postReplyRequestDto,
            @PathVariable Long articleId) {
        return replyService.postReply(userAdaptor.getMember(), postReplyRequestDto.getContent(), articleId);
    }

    @DeleteMapping("/{replyId}")
    public DeleteReplyResponseDto deleteReply(@PathVariable Long replyId) {
        return replyService.deleteReply(replyId);
    }

}
