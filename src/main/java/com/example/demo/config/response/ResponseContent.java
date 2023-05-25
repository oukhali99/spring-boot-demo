package com.example.demo.config.response;

public interface ResponseContent {
    boolean getSuccess();

    Object getPayload();

    ErrorCode getErrorCode();
}
