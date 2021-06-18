package com.chatapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class ChatApplication {

    public static void main(String[] args) {

        SpringApplication.run(ChatApplication.class, args);

        System.out.println("Hello ooooo");

    }
//    @GetMapping("/")
//    public String hello() {
//        return "Hello world";
//    }
}
