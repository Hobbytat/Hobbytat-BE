package com.example.hobbytat.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostQuestionRequestDto {
        private String title;
        private String firstContent;
        private String secondContent;
}
