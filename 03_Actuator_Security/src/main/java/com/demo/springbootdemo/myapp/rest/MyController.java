package com.demo.springbootdemo.myapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @Value("${coach.name}")
    private String cname;

    @Value("${team.name}")
    private String tname;
    @GetMapping("/teaminfo")
    public String getTeamInfo(){
    return "Coach: " + cname +", Team Name: "+tname;
}
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
