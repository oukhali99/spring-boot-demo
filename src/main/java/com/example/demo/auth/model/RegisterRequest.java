package com.example.demo.auth.model;

import com.example.demo.entities.user.Role;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
public class RegisterRequest {
    private final String username;
    private final String password;
    private final Role role;
}
