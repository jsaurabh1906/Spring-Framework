package com.myapp.aopdemo.dao;

import com.myapp.aopdemo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO {

  private String name;
  private String serviceCode;

  @Override
  public List<Account> findAccounts() {
    /*List<Account> myAccounts = new ArrayList<>();

    //create sample accounts
    Account acc1 = new Account(1,"Saurabh", "silver");
    Account acc2 = new Account(2,"Shubham", "platinum");
    Account acc3 = new Account(3,"Jaiswal", "gold");

    //add them to our accounts list
    myAccounts.add(acc1);
    myAccounts.add(acc2);
    myAccounts.add(acc3);

    return myAccounts;*/
    return findAccounts(false);
  }

  @Override
  public List<Account> findAccounts(boolean tripwire) {

    if(tripwire){
      throw new RuntimeException("This is test exception !!!");
    }
    List<Account> myAccounts = new ArrayList<>();

    //create sample accounts
    Account acc1 = new Account(1,"Saurabh", "silver");
    Account acc2 = new Account(2,"Shubham", "platinum");
    Account acc3 = new Account(3,"Jaiswal", "gold");

    //add them to our accounts list
    myAccounts.add(acc1);
    myAccounts.add(acc2);
    myAccounts.add(acc3);

    return myAccounts;
  }

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
