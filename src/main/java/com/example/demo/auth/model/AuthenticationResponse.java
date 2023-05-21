package com.example.demo.auth.model;

import com.example.demo.config.response.ApiResponse;
import lombok.*;

@Builder
@RequiredArgsConstructor
public class AuthenticationResponse implements ApiResponse {
    private final String token;

    @Override
    public boolean getSuccess() {
        return true;
    }

    @Override
    public Object getPayload() {
        return new AuthenticationPayload(token);
    }

    @Data
    @RequiredArgsConstructor
    private static class AuthenticationPayload {
        private final String token;
    }
}
