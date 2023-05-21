package com.example.demo.config.response;

public class ApiResponseSuccess extends ApiResponseBase {
    public ApiResponseSuccess(Object object) {
        super(object);
    }

    @Override
    public boolean getSuccess() {
        return true;
    }
}
