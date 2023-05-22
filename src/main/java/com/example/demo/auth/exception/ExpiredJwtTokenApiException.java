package com.example.demo.auth.exception;

import com.example.demo.exception.ApiException;

public class ExpiredJwtTokenApiException extends ApiException {
    public ExpiredJwtTokenApiException() {
        super("Jwt token is expired");
    }
}
