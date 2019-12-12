package com.github.nkolytschew.userservicems.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ExampleServiceImpl implements ExampleService {

    @Value("${spring.application.name}")
    private String applicationName;

    @Override
    public String randomServiceCall() {
        return applicationName;
    }
}
