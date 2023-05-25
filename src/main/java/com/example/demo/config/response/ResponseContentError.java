package com.example.demo.config.response;

public class ResponseContentError extends ResponseContentBase {
    private final ErrorCode errorCode;

    public ResponseContentError(Object object, ErrorCode errorCode) {
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
