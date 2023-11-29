package com.spring.todoapp.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("name")
public class WelcomeController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping("/")
    public String goToWelcomePage(ModelMap modelMap) {
        modelMap.put("name","Deepak");
        return "home";
    }

}
