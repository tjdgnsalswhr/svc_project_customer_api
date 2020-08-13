package com.example.demo.customer.core.application.object.query;

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
public class BalanceResponseDTO {
	String cid; 		//회원 아이디
	String sid; 		//가게 아이디
	int bmoney;			//해당 잔액

}
