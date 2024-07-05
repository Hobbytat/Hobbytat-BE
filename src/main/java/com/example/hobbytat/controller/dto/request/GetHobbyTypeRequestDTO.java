package com.example.hobbytat.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class GetHobbyTypeRequestDTO {
    private List<Boolean> data;
    private int size;
}
