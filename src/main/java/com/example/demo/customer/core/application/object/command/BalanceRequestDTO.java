package com.example.demo.customer.core.application.object.command;

import javax.persistence.Id;

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
public class BalanceRequestDTO {
	@ApiModelProperty(example = "teamid01")
	String cid; 		//회원 아이디
	@ApiModelProperty(example = "store01")
	String sid; 		//가게 아이디
	@ApiModelProperty(example = "500000")
	int bmoney;			//해당 잔액
}
