package com.example.demo.auth.exception;

import com.example.demo.config.response.ErrorCode;
import com.example.demo.exception.ApiException;

public class ExpiredJwtTokenApiException extends ApiException {
    public ExpiredJwtTokenApiException() {
        super("Jwt token is expired");
    }

    public ErrorCode getErrorCode() {
        return ErrorCode.EXPIRED_JWT_TOKEN;
    }
}
