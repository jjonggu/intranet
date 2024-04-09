package com.itrn.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.itrn.demo.dto.UserDto;

@Mapper
public interface UserMapper {

	void setSignUpForm(UserDto userDto);

}
