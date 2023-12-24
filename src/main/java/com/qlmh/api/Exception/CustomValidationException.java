package com.qlmh.api.Exception;

public class CustomValidationException extends RuntimeException{
    public CustomValidationException(String message) {
        super(message);
    }
}