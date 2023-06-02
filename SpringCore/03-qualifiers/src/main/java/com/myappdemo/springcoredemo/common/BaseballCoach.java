package com.myappdemo.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach{



    @Override
    public String getDailyWorkout() {
        return "Run 4km daily";
    }
}
