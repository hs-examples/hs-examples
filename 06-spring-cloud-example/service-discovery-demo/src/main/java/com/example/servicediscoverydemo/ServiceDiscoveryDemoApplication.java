package com.example.servicediscoverydemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@EnableEurekaServer
@SpringBootApplication
public class ServiceDiscoveryDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceDiscoveryDemoApplication.class, args);
	}

}
