package com.example.demo.entities.user.exception;

import com.example.demo.exception.ApiException;

public class UserNotFoundException extends ApiException {
    public UserNotFoundException(String username) {
        super("User with username " + username + " not found");
    }
}
