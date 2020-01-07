package com.github.nkolytschew.userservicems.a2.mysql.web.model;

public class AddressModel {

    private String address;

    public AddressModel() {
    }

    public AddressModel(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
