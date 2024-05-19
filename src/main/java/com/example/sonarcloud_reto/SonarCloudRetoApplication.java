package com.example.sonarcloud_reto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan({"com.example.sonarcloud_reto.config", "com.example.sonarcloud_reto.controller", "com.example.sonarcloud_reto.service", "com.example.sonarcloud_reto.service.impl", "com.example.sonarcloud_reto.repository"})
public class SonarCloudRetoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SonarCloudRetoApplication.class, args);
    }
}