package com.videostore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BaseController {

	@RequestMapping("/helloworld")
	public ModelAndView helloWorld() {
		String message = "Hello, world! Spring 3.0";
		return new ModelAndView("helloworld", "message", message);
	}
}
