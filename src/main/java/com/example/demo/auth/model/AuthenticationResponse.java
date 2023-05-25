package com.example.demo.auth.model;

import com.example.demo.config.response.ApiResponse;
import com.example.demo.config.response.ErrorCode;
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

    @Override
    public ErrorCode getErrorCode() {
        return ErrorCode.NONE;
    }

    @Data
    @RequiredArgsConstructor
    private static class AuthenticationPayload {
        private final String token;
    }
}
