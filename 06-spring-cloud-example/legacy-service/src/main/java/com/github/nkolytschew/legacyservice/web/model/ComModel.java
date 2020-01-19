package com.github.nkolytschew.legacyservice.web.model;

/**
 * This model represents the request we would be sending to the animal shelter
 * ... simplified :-)
 */
public class ComModel {

    private String user;
    private String address;

    public ComModel(String user, String address) {
        this.user = user;
        this.address = address;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
