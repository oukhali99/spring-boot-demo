package com.example.demo.config.response;

import com.example.demo.exception.ApiException;

public class ResponseContentError extends ResponseContentBase {
    private final ErrorCode errorCode;

    public ResponseContentError(Object object, ErrorCode errorCode) {
        super(object);
        this.errorCode = errorCode;
    }

    public ResponseContentError(ApiException exception) {
        super(exception.getMessage());
        this.errorCode = exception.getErrorCode();
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
