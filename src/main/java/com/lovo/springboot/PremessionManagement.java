package com.lovo.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PremessionManagement {

    public static void main(String[] args) {
        SpringApplication.run(PremessionManagement.class, args);
    }

}
