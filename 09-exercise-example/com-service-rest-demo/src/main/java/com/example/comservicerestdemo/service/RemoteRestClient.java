package com.example.comservicerestdemo.service;

import com.example.comservicerestdemo.web.model.UserModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "SPRING-DATA-DEMO")
public interface RemoteRestClient {

    @GetMapping("api/user/{id}")
    public UserModel findUserById(@PathVariable Long id);
}

