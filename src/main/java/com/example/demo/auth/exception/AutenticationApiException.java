package com.example.demo.auth.exception;

import com.example.demo.exception.ApiException;

public class AutenticationApiException extends ApiException {
    public AutenticationApiException(String username) {
        super("Failed to authenticate " + username);
    }
}
