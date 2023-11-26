package com.spring.todoapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping("/")
//	public ModelAndView sayHello() {
//		return new ModelAndView("sayHello");
//	}
	public String sayHello(){
		return "sayHello";
	}
}
