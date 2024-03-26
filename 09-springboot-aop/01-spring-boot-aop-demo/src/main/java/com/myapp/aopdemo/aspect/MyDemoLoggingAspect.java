package com.myapp.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
  //this is where we add all of our related advices for logging

  /*  //@before advice
        run the following code BEFORE - target object method : "public void AddAccount()"
  */


  //@Before("execution(public void addAccount())")
  //@Before("execution(public void com.myapp.aopdemo.dao.AccountDAO.addAccount())")
  //@Before("execution(public void add*())")
  //@Before("execution(void add*())")
  //@Before("execution(* add*(com.myapp.aopdemo.Account))")
  //@Before("execution(* add*(Account))")
  //@Before("execution(* add*(com.myapp.aopdemo.Account, ..))")
  //@Before("execution(* add*(..))")
  @Before("execution(* com.myapp.aopdemo.dao.*.*(..))")
  public void beforeAddAccountAdvice(){
    System.out.println("\n==========>>>> Executing @Before advice on addAccount()");
  }
}




/*
* ****************************************************************************
* if pointcut does not match any method,
* the advice method will not be executed..
* for ex if we use :  @Before("execution(public void addupdateAccount())")
* so the  beforeAddAccountAdvice() method will not be executed
* as there is no matching addupdateAccount() method in our application
* ****************************************************************************
*
* @Before("execution(public void addAccount())")
* this will match all the methods which are public and has void return type
* and addAccount() method name.
* hence it will match on both AccountDAOImpl and MembershipDAOImpl
* *******************************************************************************
*
*  @Before("execution(public void com.myapp.aopdemo.dao.AccountDAO.addAccount())")
* this will match only addAccount method for Account DAO
* *******************************************************************************
*
*   @Before("execution(public void add*())")
* Match method starting with add in any class
* *******************************************************************************
*
*  @Before("execution(void add*())")
* Match method with based on return type  (void) and modifiers are optional so not included
*
*  @Before("execution(* add*())")
* Match method with any return type - use wildcard *
*
* ************************************************************************************
*
* @Before("execution(* add*(com.myapp.aopdemo.Account))")
* Match params of Account type only
* its necessary to give fully qualified name o.w face error
*
* -----------------------------------------------------------------------------------------
* @Before("execution(* add*(Account))")
*  this will result in error
* error:  no match for this type name: Account [Xlint:invalidAbsoluteTypeName]
*
* -----------------------------------------------------------------------------------------
* @Before("execution(* add*(com.myapp.aopdemo.Account, ..))")
* (.. means) MAtch on any number of arguments followed by account type
*
*-----------------------------------------------------------------------------------------------------
* @Before("execution(* add*(..))")
* match on any params
*
* ----------------------------------------------------------------------------------------------------
* @Before("execution(* com.myapp.aopdemo.dao.*.*(..))")
* Match on any return type of the package com.myapp.aopdemo.dao
*  with any class and any method with any params
* in short match on package name
*
* ** for more refer help.md file ==>> Parameter Pattern Wildcards **
* ****************************************************************************************************************
*
*
*  */