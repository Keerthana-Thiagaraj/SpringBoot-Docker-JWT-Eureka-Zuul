package com.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EnableEurekaClient
@EnableTransactionManagement
@EnableCaching
public class HouseHoldApplication {

    public static void main(String[] args) {

        SpringApplication.run(HouseHoldApplication.class, args);
    }

}

