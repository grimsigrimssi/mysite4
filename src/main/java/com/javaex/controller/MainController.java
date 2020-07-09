package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	
	@RequestMapping(value="/main", method = {RequestMethod.GET, RequestMethod.POST})
	public String test() {
		System.out.println("main>main()");
		
		return "main/index"; //뷰 리졸버 확인할 것!
	}

}
