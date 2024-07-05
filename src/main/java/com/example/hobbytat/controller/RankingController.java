package com.example.hobbytat.controller;

import com.example.hobbytat.controller.dto.response.GetArticlesRankingResponseDto;
import com.example.hobbytat.controller.dto.response.GetTypeRankingsResponseDto;
import com.example.hobbytat.controller.dto.response.SimpleArticleRankResponseDto;
import com.example.hobbytat.controller.dto.response.SimpleTypeRankResponseDto;
import com.example.hobbytat.service.RankingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/rankings")
public class RankingController {
    private final RankingService rankingService;

    @GetMapping("/types")
    public GetTypeRankingsResponseDto getTypeRankings() {
        List<SimpleTypeRankResponseDto> typeRankings = rankingService.getTypeRankings();

        return GetTypeRankingsResponseDto.builder()
                .isSuccess(true)
                .status(200)
                .size(typeRankings.size())
                .data(typeRankings)
                .build();
    }

    @GetMapping("/articles")
    public GetArticlesRankingResponseDto getArticlesRankings() {
        List<SimpleArticleRankResponseDto> articleRankings = rankingService.getArticleRankings();

        return GetArticlesRankingResponseDto.builder()
                .isSuccess(true)
                .status(200)
                .data(articleRankings)
                .size(articleRankings.size())
                .build();
    }

}
