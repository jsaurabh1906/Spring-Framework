package com.myapp.aopdemo.dao;

import com.myapp.aopdemo.Account;

import java.util.List;

public interface AccountDAO {

  List<Account> findAccounts();
  List<Account> findAccounts(boolean tripwire);

  void addAccount(Account acc);

  void addAccount(Account acc, boolean vipFlag);

  boolean doWork();


  public String getName() ;

  public void setName(String name);

  public String getServiceCode() ;

  public void setServiceCode(String serviceCode) ;


}
