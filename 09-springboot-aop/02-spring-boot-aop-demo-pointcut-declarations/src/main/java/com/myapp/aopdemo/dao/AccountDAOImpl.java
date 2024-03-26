package com.myapp.aopdemo.dao;

import com.myapp.aopdemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {

  private String name;
  private String serviceCode;
  @Override
  public void addAccount(Account acc) {
    System.out.println(getClass() + ": Doing my db work: Adding a account");
  }

  @Override
  public void addAccount(Account acc, boolean vipFlag) {
    System.out.println(getClass() + ": Doing my db work: Adding a account and vip flag");

  }

  @Override
  public boolean doWork() {
    System.out.println(getClass() + ": So Do some work...");
    return true;
  }

  public String getName() {
    System.out.println("Inside getter method: getName()");
    return name;
  }

  public void setName(String name) {
    System.out.println("Inside setter method: setName()");
    this.name = name;
  }

  public String getServiceCode() {
    System.out.println("Inside getter method: getServiceCode()");
    return serviceCode;
  }

  public void setServiceCode(String serviceCode) {
    System.out.println("Inside setter method: setServiceCode()");
    this.serviceCode = serviceCode;
  }
}
