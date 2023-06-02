package com.myappdemo.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{

    public TennisCoach(){
        System.out.println("In Constructor: "+ getClass().getName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice with ur colleague for tennis";
    }
}
