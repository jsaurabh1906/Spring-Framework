package com.myapp.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO {
  @Override
  public void addAccount() {
    System.out.println(getClass() + ": Doing my db work: Adding a Membership account");
  }

  @Override
  public boolean addSillyMemberAccount() {
    System.out.println(getClass() + ":  Adding some silly Member");

    return true;
  }

  @Override
  public void goToSleep() {
    System.out.println(getClass() + ": go to sleep...");

  }
}
