package com.example.comservicerestdemo.web.controller;


import com.example.comservicerestdemo.service.RemoteService;
import com.example.comservicerestdemo.web.model.UserModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RemoteComController {

    private RemoteService service;

    public RemoteComController(RemoteService service) {
        this.service = service;
    }

    @GetMapping("findUsers")
    public List<UserModel> findAllUser(){
        return service.getAllUsers();
    }

}
