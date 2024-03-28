package com.myapp.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect  // optional if we only have pointcuts
@Component
public class AppAopExpressions {
  @Pointcut("execution(* com.myapp.aopdemo.dao.*.*(..))")
  public void forDaoPackage(){}

  //create pointcut for getter methods
  @Pointcut("execution(* com.myapp.aopdemo.dao.*.get*(..))")
  public void getter(){}

  //create pointcut for setter methods
  @Pointcut("execution(* com.myapp.aopdemo.dao.*.set*(..))")
  public void setter(){}

  //combining pointcuts
  //create pointcut: include package and exclude getter/setter
  @Pointcut("forDaoPackage() && !(getter() || setter())")
  public void forDaoPackageWithoutGetterSetter(){}
}
