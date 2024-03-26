package com.myapp.aopdemo.dao;

import com.myapp.aopdemo.Account;

public interface AccountDAO {

  void addAccount(Account acc);

  void addAccount(Account acc, boolean vipFlag);

  boolean doWork();


  public String getName() ;

  public void setName(String name);

  public String getServiceCode() ;

  public void setServiceCode(String serviceCode) ;
}
