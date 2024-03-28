package com.myapp.aopdemo.aspect;

import com.myapp.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

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



  //add a new advice for AfterReturning on the findAccounts Method
  @AfterReturning(
      pointcut = "execution(* com.myapp.aopdemo.dao.AccountDAO.findAccounts(..))",
      returning = "result"
  )
  public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result){
    //print out which method we are advising on
    String method = joinPoint.getSignature().toShortString();
    System.out.println("\n========>>>>> Executing @AfterReturning on method: "+ method);

    //print out the results of the method call
    System.out.println("\n=========>>>>> Result: "+ result);

    //doing some post-processing.....modify the result, add, remove

    //convert the names to upppercase
    convertAccountNamesToUpperCase(result);

    System.out.println("\n=========>>>>>Modified Result: "+ result);


  }

  private void convertAccountNamesToUpperCase(List<Account> result) {
    for (Account acc: result) {
      String  modifiedName = acc.getName().toUpperCase();
      acc.setName(modifiedName);
    }
  }

  @AfterThrowing(
      pointcut = "execution(* com.myapp.aopdemo.dao.AccountDAO.findAccounts(..))",
      throwing = "theExc"
  )
  public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable theExc){
    //print out which method we are advising on
    String method = joinPoint.getSignature().toShortString();
    System.out.println("\n========>>>>> Executing @AfterThrowing on method: "+ method);

   //log the exception
    System.out.println("\n========>>>>> The exception is "+ theExc);


  }


  @After( "execution(* com.myapp.aopdemo.dao.AccountDAO.findAccounts(..))"
  )
  public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint){
    //print out which method we are advising on
    String method = joinPoint.getSignature().toShortString();
    System.out.println("\n========>>>>> Executing @After (finally) on method: "+ method);

  }

  @Around("execution(* com.myapp.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{

    //print method we are advising
    String method = proceedingJoinPoint.getSignature().toShortString();
    System.out.println("\n========>>>>> Executing @Around on method: "+ method);

    //get begin timestamp
    long begin = System.currentTimeMillis();

    //execute the method
    //Object result = proceedingJoinPoint.proceed();
    Object result = null;

    try {
      result = proceedingJoinPoint.proceed();
    }
    catch (Exception exc){
      // log the exception
      System.out.println(exc.getMessage());

      //give user a custom message (Exception hadling)
      //result = "Major Accident! But no worries, your AOP is on way ";

      //rethrow Exception
      throw exc;
    }

    //get end timestamp
    long end = System.currentTimeMillis();

    //compute duration and display
    long duration = end - begin;
    System.out.println("\n====>>>> Duration: "+ duration/1000 +" seconds");

    return result;
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