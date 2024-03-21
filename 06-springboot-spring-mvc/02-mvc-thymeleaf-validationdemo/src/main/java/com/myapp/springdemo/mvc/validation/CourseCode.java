package com.myapp.springdemo.mvc.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {

    //define default course code
    public String value() default  "SHUBH";

    //define default error message
    public String message() default  "must start with SHUBH";

    //define default groups
    public Class<?>[] groups() default {};

    //define default payloads
    public Class<? extends Payload>[] payload() default {};
}

/*
* CourseCodeConstraintValidator : Helper class that contains business rules/ validation logic
* @Target: where to apply our annotation like on fields, methods, ...
* @Retention: Retain this annotation in the java class file. Process it at runtime
* */