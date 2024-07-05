package com.example.hobbytat.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class QuestionResult {

    private boolean isSuccess;
    private int status;
    private String first_content;
    private Integer first_percent;
    private String second_content;
    private Integer second_percent;
}
