package com.example.demo.config.response;

public abstract class ResponseContentBase implements ResponseContent {
    private final Object object;

    public ResponseContentBase(Object object) {
        this.object = object;
    }

    @Override
    public Object getPayload() {
        return object;
    }
}
