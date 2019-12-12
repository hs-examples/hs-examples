package com.example.comservicerestdemo.web.model;

public class UserModel {

    private String fullName;
    private String url;

    // for jackson
    public UserModel() {
    }

    public UserModel(String fullName, String url) {
        this.fullName = fullName;
        this.url = url;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

