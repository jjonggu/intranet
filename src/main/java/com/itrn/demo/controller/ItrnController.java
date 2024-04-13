package com.itrn.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itrn.demo.dto.UserDto;
import com.itrn.demo.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/itrn")
@RequiredArgsConstructor
public class ItrnController {
	
	private final UserService userService;
	
	@GetMapping("/main")
	 public String Main() {
		return "itrn/index";
	 }
	
	@GetMapping("board")
	public String Board(Model model, UserDto userDto) {
		List<UserDto> userList = userService.getUserList(userDto);
		model.addAttribute("userList", userList);
		return "itrn/tables";
	}
	
	@GetMapping("/usr-detail")
	@ResponseBody
	public Map<String, Object> UsrDetail(@RequestParam String usrEmail, Model model) {
		UserDto usrDto = userService.getUserDetail(usrEmail);
		model.addAttribute("usrDto", usrDto);
		System.out.println("!!!!!!!!!!!!!!!" + usrDto);
		return Map.of("message", "성공 하였습니다.");
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
