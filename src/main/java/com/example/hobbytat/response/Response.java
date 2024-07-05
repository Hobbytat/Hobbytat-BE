package com.example.hobbytat.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Response {
    private final boolean isSuccess;
    private final int status;
}


