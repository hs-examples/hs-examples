package com.example.comservicerestdemo.web.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping("hi")
    public String gethigh(){
        return "i am so hi";
    }
}
