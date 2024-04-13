package com.itrn.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.itrn.demo.dto.UserDto;
import com.itrn.demo.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

	@PostMapping("/user/sign-up-form")
	public Map<String, Object> SignUpForm(@RequestBody UserDto userDto) {
		userService.setSignUpForm(userDto);
		return Map.of("Msg", "회원가입 하셨습니다.");
	}

	@PostMapping("/user/sign-in-form")
	@ResponseBody
	public Map<String, Object> SignInForm(@RequestBody UserDto userDto, Model model) {
		
		// 사용자가 입력하 정보 (아이디, 비밀번호)
		UserDto userSignIn = userService.setSignInForm(userDto);
		
		// 로그인 콘솔 에러 차단
		if (userSignIn == null) {
			return null;
		}

		// 사용자 목록
		List<UserDto> userList = userService.getUserList(userDto);
		
		// 화면에 표출 데이터		
		model.addAttribute("userList", userList);

		// userList 배열로 input value 값 비교
		for (UserDto user : userList) {
			if (userSignIn.getUserEmail().equals(user.getUserEmail())) {
				return Map.of("Msg", "로그인 하였습니다.");
			}
		}
		return Map.of("Msg", "로그인에 실패했습니다. 이메일 또는 비밀번호가 올바르지 않습니다.");
	}
}