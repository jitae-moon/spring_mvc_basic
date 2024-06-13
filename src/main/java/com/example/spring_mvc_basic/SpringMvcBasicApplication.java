package com.example.spring_mvc_basic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan // Servlet 자동 등록
@SpringBootApplication
public class SpringMvcBasicApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMvcBasicApplication.class, args);
    }

}
