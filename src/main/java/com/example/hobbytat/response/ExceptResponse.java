package com.example.hobbytat.response;

import lombok.Data;

@Data
public class ExceptResponse {
    private final boolean isSuccess;
    private final int status;
    private final String errorMessage;
}