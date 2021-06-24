package com.chatapplication.web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController2 {

    @RequestMapping("/home")
    public String home2() {
        return "This is another HomeController!";
    }

    @RequestMapping("/home2")
    public String home() {
        return "Just starting with Spring Boot!";
    }
}
