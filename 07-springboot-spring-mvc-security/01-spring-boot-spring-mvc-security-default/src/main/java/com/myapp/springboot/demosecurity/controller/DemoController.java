package com.myapp.springboot.demosecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
    @GetMapping("/")
    public String showHome(){
        return "home";   //thymeleaf template name
    }

    @GetMapping("/leaders")
    public String showLeaders(){
        return "leaders";   //thymeleaf template name
    }
    @GetMapping("/systems")
    public String showSystems(){
        return "systems";   //thymeleaf template name
    }
}
