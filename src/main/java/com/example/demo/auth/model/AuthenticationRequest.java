package com.example.demo.auth.model;

import lombok.*;

@Data
@Builder
@RequiredArgsConstructor
public class AuthenticationRequest {
    private final String username;
    private final String password;
}
