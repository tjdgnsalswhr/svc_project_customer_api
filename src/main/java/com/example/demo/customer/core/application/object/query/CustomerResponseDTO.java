package com.example.demo.customer.core.application.object.query;

import com.example.demo.customer.core.application.object.command.CustomerRequestDTO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ToString
@NoArgsConstructor
@Getter
@Setter
public class CustomerResponseDTO {
	
	String cid; 			//회원 아이디
	String cpassword; 	//회원 비밀번호
	String cname; 	//회원 이름
	String code; //1이면 팀 2면 가게
}
