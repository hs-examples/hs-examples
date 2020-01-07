package com.github.nkolytschew.userservice.a2.mysql.web.model;


public class UserModel {
    private String username;

    public UserModel() {
    }

    public UserModel(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
