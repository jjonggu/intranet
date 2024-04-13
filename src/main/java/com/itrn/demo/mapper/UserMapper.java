package com.itrn.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.itrn.demo.dto.UserDto;

@Mapper
public interface UserMapper {

	void setSignUpForm(UserDto userDto);

	UserDto setSignInForm(UserDto userDto);

	List<UserDto> getUserList(UserDto userDto);

	UserDto getUserDetail(String userEmail);

}
