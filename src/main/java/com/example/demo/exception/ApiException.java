package com.example.demo.exception;

import com.example.demo.config.response.ErrorCode;

public class ApiException extends RuntimeException {
    public ApiException(String message) {
        super(message);
    }

    public ErrorCode getErrorCode() {
        return ErrorCode.GENERAL_ERROR;
    }
}
