package com.sens.social;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication(scanBasePackages = "com.sens.social")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}