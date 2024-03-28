package com.myapp.aopdemo.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;
@Service
public class FortuneServiceImpl implements FortuneService{
  @Override
  public String getFortune() {
    // simulate a delay

    try {
      TimeUnit.SECONDS.sleep(5);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    // return a fortune
    return "Expect Heavy Traffic this Morning";

  }

  @Override
  public String getFortune(boolean tripWire) {
    if(tripWire){
      throw new RuntimeException("Major Accident! Highway is closed..");

    }
    return getFortune();
  }
}
