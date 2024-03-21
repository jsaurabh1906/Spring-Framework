package com.myapp.springdemo.mvc;

import com.myapp.springdemo.mvc.validation.CourseCode;
import jakarta.validation.constraints.*;

public class Customer {
    private String firstName;

    @NotNull(message="Name is required")
    @Size(min=1, message="is required")
    private String lastName = "";

    @Min(value = 0, message = "must be greater than or equal to 0")
    @Max(value = 10, message = "must be less than or equal to 10")
    @NotNull(message = "required!!")
    private Integer freePasses;

    @Pattern(regexp = "^[A-Za-z0-9]{6}", message="only Max 6 chars/digits")
    private String postalCode;

    @CourseCode(value = "ABC", message = "must start with ABC")
    private String courseCode;
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
}
