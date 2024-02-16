package com.example.carapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CarApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarApiApplication.class, args);
    }

}
