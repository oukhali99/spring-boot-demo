package com.example.demo.auth.exception;

import com.example.demo.exception.ApiException;

public class MyAuthenticationException extends ApiException {
    public MyAuthenticationException(String username) {
        super("Failed to authenticate " + username);
    }
}
