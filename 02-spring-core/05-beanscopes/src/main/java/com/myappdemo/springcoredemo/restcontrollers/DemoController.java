package com.myappdemo.springcoredemo.restcontrollers;

import com.myappdemo.springcoredemo.common.Coach;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach myCoach;
    private Coach anotherCoach;
    //constructor injection with default scope= singleton
    @Autowired
    public DemoController( @Qualifier("cricketCoach") Coach theCoach
                            , @Qualifier("cricketCoach") Coach theanotherCoach){
       System.out.println("IN Demo Controller");
        myCoach=theCoach;
        anotherCoach=theanotherCoach;
    }
 
    @GetMapping("/check")
    public String check(){
        return "Comparing beans: myCoach==anotherCoach, " + (myCoach == anotherCoach);
    }


    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }


    //define init method
    @PostConstruct
    public void doStartupStuff(){
        System.out.println("in dostartupstuff():"+ getClass().getSimpleName());
    }

    //define destroy method
    @PreDestroy
    public void doCleanpStuff(){
        System.out.println("in docleanupstuff():"+ getClass().getSimpleName());
    }
}



/* bean life cycle

container started

bean instantiated
dependencies injected 
internal spring processing
our custom init method
bean is ready for use 

if container shutdown 

our custom destroy method
*/