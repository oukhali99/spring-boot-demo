package com.example.demo.auth.model;

import lombok.*;

@Data
@Builder
@RequiredArgsConstructor
public class AuthenticationResponse {
    private final String token;
}
