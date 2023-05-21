package com.example.demo.config.response;

public abstract class ApiResponseBase implements ApiResponse {
    private final Object object;

    public ApiResponseBase(Object object) {
        this.object = object;
    }

    @Override
    public Object getPayload() {
        return object;
    }
}
