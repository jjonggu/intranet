package com.itrn.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
	
	private int userNo;
	private String userEmail;
	private String userName;
	private String userPw;
	private String userPhone;
	// 테이블 DATE 타입으로 생성 시 String 
	private String  signupDt;

}