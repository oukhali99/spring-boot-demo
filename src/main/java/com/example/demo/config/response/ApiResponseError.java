package com.example.demo.config.response;

public class ApiResponseError extends ApiResponseBase {
    public ApiResponseError(Object object) {
        super(object);
    }

    @Override
    public boolean getSuccess() {
        return false;
    }
}
