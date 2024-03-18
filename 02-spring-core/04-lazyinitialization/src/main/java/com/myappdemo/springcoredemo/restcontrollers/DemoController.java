package com.myappdemo.springcoredemo.restcontrollers;

import com.myappdemo.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach myCoach;
    //constructor injection with qualifier
    @Autowired
    public DemoController( @Qualifier("baseballCoach") Coach theCoach){
       System.out.println("IN Demo Controller");
        myCoach=theCoach;
    }


    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }
}
