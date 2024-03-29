package com.myapp.springbootrestdemo.restcontroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {

    //exception handler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException studexep){

        // create a studenterrorresponse
        StudentErrorResponse error =new StudentErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(studexep.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        //return response

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    //add another exception handler to catch any other exceptions
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception e){
        // create a studenterrorresponse

        StudentErrorResponse error =new StudentErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(e.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        //return response

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}

/*
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException studexep){

    @ExceptionHandler : Exception Handler Method
    <StudentErrorResponse> :  type of the response body which is defined in the StudentErrorResponse Class
    StudentNotFoundException studexep :exception type to handle? catch



    @ConstrollerAdvice : Real-time use of AOP
    @ConstrollerAdvice:
            it pre-process requests to controllers
            post-process response to handle exceptions
            perfect for global exception handling
*/
