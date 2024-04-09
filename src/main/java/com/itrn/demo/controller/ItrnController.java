package com.itrn.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/itrn")
public class ItrnController {
	
	@GetMapping("/main")
	 public String Main() {
		return "itrn/index";
	 }
	
	@GetMapping("/sign-in")
	public String SignIn() {
		return "itrn/sign-in";
	}
	
	@GetMapping("/sign-up")
	public String SignUp() {
		return "itrn/sign-up";
	}

}
