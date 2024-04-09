 package com.itrn.demo.service;

import org.springframework.stereotype.Service;

import com.itrn.demo.dto.UserDto;
import com.itrn.demo.mapper.UserMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	
	private final UserMapper userMapper;

	public void setSignUpForm(UserDto userDto) {
		// 회원가입 예외처리 Msg console.log 메세지로 받기위해 메서드 타입을 String 받았다.
		// 하지만 insert는 resultType 받을게 없기에.. 생각 다시 해보기로
		userMapper.setSignUpForm(userDto);
	}

}
