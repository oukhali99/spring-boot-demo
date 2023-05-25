package com.example.demo.config.response;

public class ResponseContentSuccess extends ResponseContentBase {
    public ResponseContentSuccess(Object object) {
        super(object);
    }

    @Override
    public boolean getSuccess() {
        return true;
    }

    @Override
    public ErrorCode getErrorCode() {
        return ErrorCode.NONE;
    }
}
