package com.example.hobbytat.service;

import com.example.hobbytat.controller.dto.response.SimpleArticleRankResponseDto;
import com.example.hobbytat.controller.dto.response.SimpleTypeRankResponseDto;
import com.example.hobbytat.domain.Article;
import com.example.hobbytat.domain.HobbyType;
import com.example.hobbytat.repository.ArticleRepository;
import com.example.hobbytat.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RankingService {
    private final MemberRepository memberRepository;
    private final ArticleRepository articleRepository;

    public List<SimpleTypeRankResponseDto> getTypeRankings() {
        long allCount = memberRepository.count();
        if (allCount == 0) {
            return Collections.emptyList();
        }

        HobbyType[] types = HobbyType.values();

        List<SimpleTypeRankResponseDto> typeRankResponseDtoList = new ArrayList<>();
        for (HobbyType type : types) {
            long typeCount = memberRepository.countByHobbyType(type);
            double percent = ((double) typeCount/allCount) * 100;
            SimpleTypeRankResponseDto typeRankResponseDto = SimpleTypeRankResponseDto.builder()
                    .hobbyType(type)
                    .percent((int) percent)
                    .build();
            typeRankResponseDtoList.add(typeRankResponseDto);
        }
        typeRankResponseDtoList.sort(Comparator.comparingInt(SimpleTypeRankResponseDto::getPercent).reversed());

        for (int i = 1; i < typeRankResponseDtoList.size() + 1; i++) {
            typeRankResponseDtoList.get(i-1).setRank(i);
        }

        return typeRankResponseDtoList;
    }

    public List<SimpleArticleRankResponseDto> getArticleRankings() {
        List<Article> articles = articleRepository.findTop5ByOrderByViewCountDesc();

        return articles.stream()
                .map(SimpleArticleRankResponseDto::toDto)
                .collect(Collectors.toList());
    }
}
