package com.myapp.aopdemo.dao;

import com.myapp.aopdemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {
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
}
