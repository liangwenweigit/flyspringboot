package com.fly.flyspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/api")
public class UserController {
	@RequestMapping("/get")
	public String get(){
		
		
		return "index";
	}

}
