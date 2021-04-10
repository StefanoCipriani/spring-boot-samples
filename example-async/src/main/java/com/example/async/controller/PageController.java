package com.example.async.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

	@GetMapping("/home")
	public ModelAndView getHomePage() {
		
		ModelAndView  mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}
	
	@GetMapping("/page2")
	public ModelAndView getPage2() {
		
		ModelAndView  mv = new ModelAndView();
		mv.setViewName("page2");
		return mv;
	}
}
