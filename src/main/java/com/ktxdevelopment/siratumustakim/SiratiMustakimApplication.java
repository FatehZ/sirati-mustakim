package com.ktxdevelopment.siratumustakim;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class, UserDetailsServiceAutoConfiguration.class, WebMvcAutoConfiguration.class})
@ComponentScan(value = "com.ktxdevelopment.siratumustakim.auth.security.controller")
public class SiratiMustakimApplication {

    public static void main(String[] args) {
        SpringApplication.run(SiratiMustakimApplication.class, args);
    }
}