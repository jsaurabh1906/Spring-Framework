package com.myappdemo.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach{

public BaseballCoach(){
    System.out.println("In Constructor: "+ getClass().getName());
}

    @Override
    public String getDailyWorkout() {
        return "Run 4km daily";
    }
}
