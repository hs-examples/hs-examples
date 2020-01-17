package com.example.comservicerestdemo.service;

import com.example.comservicerestdemo.web.model.UserModel;

import java.util.List;

public interface RemoteService {

    List<UserModel> getAllUsersByClient();

    List<UserModel> getAllUsers();

}
