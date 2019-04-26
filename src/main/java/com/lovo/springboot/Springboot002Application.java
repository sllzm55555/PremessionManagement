package com.lovo.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Springboot002Application {

    public static void main(String[] args) {
        SpringApplication.run(Springboot002Application.class, args);
    }

}
