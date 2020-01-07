package com.github.nkolytschew.userservice.service.impl;

import com.github.nkolytschew.userservice.service.ExampleService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("!dev")
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
