package com.itrn.demo.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itrn.demo.dto.UserDto;
import com.itrn.demo.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
	
	private final UserService userService;
	
	@PostMapping("/sign-up-form")
	public Map<String, Object> SignUpForm(@RequestBody UserDto userDto){
		userService.setSignUpForm(userDto);
		return Map.of("Msg", "성공 하셨습니다.");
	}
}
