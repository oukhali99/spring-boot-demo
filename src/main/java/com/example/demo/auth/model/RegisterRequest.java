package com.example.demo.auth.model;

import com.example.demo.exception.ApiException;

public record RegisterRequest(String username, String password) {
    public RegisterRequest {
        if (username == null) {
            throw new ApiException("username cannot be null");
        }
        if (password == null) {
            throw new ApiException("password cannot be null");
        }
    }
}
