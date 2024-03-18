package com.myappdemo.springcoredemo.restcontrollers;

import com.myappdemo.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    // define a private field for the dependency
    private Coach myCoach;

    //constructor for dependency injection
    //autowired to tell spring to inject a dependency
    @Autowired
    DemoController(Coach theCoach ){
        myCoach=theCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }
}
