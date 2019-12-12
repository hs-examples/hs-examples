package com.github.nkolytschew.userservicems.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ExampleServiceImpl implements ExampleService {

    private final String applicationName;

    public ExampleServiceImpl(@Value("${spring.application.name}") String applicationName) {
        this.applicationName = applicationName;
    }

    @Override
    public String randomServiceCall() {
        return applicationName;
    }
}
