package com.business;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SsBeautyProductsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SsBeautyProductsApplication.class, args);
    }
}

