package com.myapp.springboot.thmeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    //create a mapping for /hello
    @GetMapping("/hello")
    public String sayHello(Model model){
        model.addAttribute("theDate",new java.util.Date());
        // return name must be same as that of file in resources/templates
        return "helloworld";
    }

}
