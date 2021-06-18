package com.chatapplication;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController2 {

    @RequestMapping("/home")
    public String home2() {
        return "This is another HomeController!";
    }
}
