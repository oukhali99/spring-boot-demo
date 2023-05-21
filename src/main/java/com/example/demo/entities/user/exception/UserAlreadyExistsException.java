package com.example.demo.entities.user.exception;

import com.example.demo.exception.ApiException;

public class UserAlreadyExistsException extends ApiException {
    public UserAlreadyExistsException(String username) {
        super("User with username " + username + " already exists");
    }
}
