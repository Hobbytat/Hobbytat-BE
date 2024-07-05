package com.example.hobbytat.exception;

import com.example.hobbytat.response.ExceptResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ExceptionHandlers  {

    @ExceptionHandler({NoSuchEntityException.class})
    public ResponseEntity<ExceptResponse> handleNoSuchEntityException(NoSuchEntityException e){
        log.error("ERROR", e);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ExceptResponse(false, 500, e.getMessage()));
    }

    // DEFAULT Exception
    @ExceptionHandler({Exception.class})
    public ResponseEntity<ExceptResponse> handleException(Exception e){
        log.error("ERROR", e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ExceptResponse(false, 500, e.getMessage()));
    }
}