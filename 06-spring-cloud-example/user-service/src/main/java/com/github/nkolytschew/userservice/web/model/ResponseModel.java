package com.github.nkolytschew.userservice.web.model;

public class ResponseModel {
    private String message;

    public ResponseModel(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
