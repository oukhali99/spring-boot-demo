package com.example.demo.config.response;

public class ApiResponseError extends ApiResponseBase {
    private final ErrorCode errorCode;

    public ApiResponseError(Object object, ErrorCode errorCode) {
        super(object);
        this.errorCode = errorCode;
    }

    @Override
    public boolean getSuccess() {
        return false;
    }

    @Override
    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
