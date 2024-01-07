package com.srijan.myjpawork.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.NoSuchElementException;

@ControllerAdvice
public class MyApiGlobalAdviceHandler {

    @ExceptionHandler(value = {MyCommonApiException.class})
    public ResponseEntity<Object> handleEmptyInput(MyCommonApiException exception){
        //MyResponseAPIException apiException = new MyResponseAPIException(exception.getMessage(), exception, HttpStatus.BAD_REQUEST, ZonedDateTime.now(ZoneId.of("Z")));
        MyResponseAPIException apiException = new MyResponseAPIException(exception.getMessage(), HttpStatus.BAD_REQUEST, ZonedDateTime.now(ZoneId.of("Z")));
        return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }

}
