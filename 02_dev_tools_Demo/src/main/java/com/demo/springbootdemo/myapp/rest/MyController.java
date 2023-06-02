package com.demo.springbootdemo.myapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @GetMapping("/")
    public String sayHello(){
        return "Hello Saurabh!!!";
    }

    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "Run fast";
    }
    @GetMapping("/fortune")
    public String getFortune(){
        return "Lucky Day!!!";
    }


}
