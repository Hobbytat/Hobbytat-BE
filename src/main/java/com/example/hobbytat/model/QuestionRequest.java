package com.example.hobbytat.model;

import com.example.hobbytat.domain.BalanceGameChoice;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class QuestionRequest {
        private Long memberId;
        private Long questionId;
        private String choice;
}
