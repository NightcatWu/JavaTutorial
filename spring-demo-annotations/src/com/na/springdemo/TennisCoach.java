package com.na.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

    private FortuneService fortuneService;

    public TennisCoach() {
        System.out.println(">> TennisCoach : default constructor");
    }

    // Constructor injection
//    @Autowired
//    public TennisCoach(FortuneService theFortuneService) {
//        fortuneService = theFortuneService;
//    }

    // setter injection
    @Autowired
    public void setFortuneService(FortuneService theFortuneService) {
        fortuneService = theFortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "TennisCoach : Practice your backhand volley. ";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}