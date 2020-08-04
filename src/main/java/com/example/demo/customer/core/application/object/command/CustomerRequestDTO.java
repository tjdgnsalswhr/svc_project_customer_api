package com.example.demo.customer.core.application.object.command;

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
public class CustomerRequestDTO {
	
	@ApiModelProperty(example = "teamid01")
	String cid; 			//회원 아이디
	
	@ApiModelProperty(example = "teampassword01")
	String cpassword; 	//회원 비밀번호
	
	@ApiModelProperty(example = "Digital Poc")
	String cname; 	//회원 이름
	
	@ApiModelProperty(example = "1")
	String code; //1이면 팀 2면 가게
	
	@ApiModelProperty(example = "1000000")
	int balance; 	//잔액

}
