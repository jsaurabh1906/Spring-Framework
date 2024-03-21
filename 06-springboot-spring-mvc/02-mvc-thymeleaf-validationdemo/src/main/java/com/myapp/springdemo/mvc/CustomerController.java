package com.myapp.springdemo.mvc;

import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    //Model allows us to share information between controllers and view pages(thymeleaf)
    @GetMapping("/")
    public String showForm(Model model){

        model.addAttribute("customer", new Customer());
        return "customer-form"; //bind with cusstomer-form.html
    }

    @PostMapping("/processForm")
    public String processForm(
            @Valid @ModelAttribute("customer") Customer customer,
            BindingResult theBR)
    {

        System.out.println("Last name: |" + customer.getLastName() + "|");

        System.out.println("Binding Results: " + theBR.toString());

        if(theBR.hasErrors()){
            return "customer-form";
        }
        else{
            return "customer-confirmation";
        }
    }
}


/*
*  @Valid : tell spring mvc to perform validation
*  @ModelAttribute :  read the form data from customer attribute
*  BindingResult : holds the results of validation
*
*  @InitBinder : pre-process all web requests coming into our controller
*  StringTrimmerEditor :it is defined in Spring API
*        removes whitespaces, both leading and trailing;
*        true means trim to null
*/