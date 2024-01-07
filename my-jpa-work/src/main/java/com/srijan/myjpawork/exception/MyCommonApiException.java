package com.srijan.myjpawork.exception;

public class MyCommonApiException extends RuntimeException{

    public MyCommonApiException(String message) {
        super(message);
    }

    public MyCommonApiException(String message, Throwable cause) {
        super(message, cause);
    }
}
