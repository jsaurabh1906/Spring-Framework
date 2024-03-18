package com.myappdemo.springcoredemo.restcontrollers;

import com.myappdemo.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach myCoach;
/*


 //Qualifier has highest priority as compared to primary annotation


   //constructor injection with qualifier
    @Autowired
    public DemoController( @Qualifier("baseballCoach") Coach theCoach){
        myCoach=theCoach;
    }

*/


//constructor injection with primary annotation used
@Autowired
public DemoController(Coach theCoach){

    myCoach=theCoach;
}
/*
    //setter injection
    @Autowired
   public void setCoach(@Qualifier("cricketCoach") Coach theCoach){
        myCoach=theCoach;
    }
 */
    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }
}
