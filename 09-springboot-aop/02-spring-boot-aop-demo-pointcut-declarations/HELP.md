# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.2.4/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.2.4/maven-plugin/reference/html/#build-image)

### AOP: Pointcut Expressions
* Pointcut : A predicate expression for where advice should be applied.

![img.png](Images/imgdemo.png)

* Pointcut Expression Language

![img.png](Images/img.png)

Modifiers: (Spring AOP only supports public)
Return type: void,boolean,String,List<Customer>,....
Declaring type: the class name
Method Name: method name to match and parameters types to match
Throws: exception types to match

* Examples: 
    
![img_1.png](Images/img_1.png)
![img_2.png](Images/img_2.png)
![img_3.png](Images/img_3.png)
![img_4.png](Images/img_4.png)
![img_5.png](Images/img_5.png)
![img_6.png](Images/img_6.png)

* Parameter Pattern Wildcards
 
![img_7.png](Images/img_7.png)
![img_8.png](Images/img_8.png)
![img_9.png](Images/img_9.png)
![img_10.png](Images/img_10.png)
![img_11.png](Images/img_11.png)

* Pointcut Declarations 

![img_12.png](Images/img_12.png)
![img_13.png](Images/img_13.png)
![img_14.png](Images/img_14.png)
![img_15.png](Images/img_15.png)