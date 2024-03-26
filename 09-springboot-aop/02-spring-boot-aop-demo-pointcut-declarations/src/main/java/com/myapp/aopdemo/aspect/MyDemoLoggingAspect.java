package com.myapp.aopdemo.aspect;

import com.myapp.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

  @Before("com.myapp.aopdemo.aspect.AppAopExpressions.forDaoPackageWithoutGetterSetter()")
  public void beforeAddAccountAdvice(JoinPoint joinPoint){
    System.out.println("\n==========>>>> Executing @Before advice on addAccount()");

    //display the method signature
    MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
    System.out.println("Method: "+ methodSignature);

    //display method arguments

    //get the arguments
    Object[] args = joinPoint.getArgs();
    
    //loop through arguments
    for (Object arg:args
         ) {
      System.out.println(arg);
      if(arg instanceof Account){
        //downcast and print Account specific material
        Account acc = (Account) arg;
        System.out.println("Account Name: "+ acc.getName());
        System.out.println("Account Name: "+ acc.getLevel());
      }
    }

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
* ### PointCut Declarations:
*
*
*
*   @Pointcut("execution(* com.myapp.aopdemo.dao.*.*(..))")
*   private void forDaoPackage(){}
*
*    forDaoPackage is the name of pointcut and it ccan be any name
*
*
*
*
*
*  */