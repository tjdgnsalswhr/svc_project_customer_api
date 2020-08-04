package com.example.demo.customer.controller.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.customer.core.application.object.command.CustomerRequestDTO;
import com.example.demo.customer.core.service.CustomerBillingService;

import io.swagger.annotations.ApiOperation;

@RestController
public class CustomerBillingController {
	
	@Autowired
	CustomerBillingService customerBillingService;
	
	@ApiOperation(value = "회원 금액 충전", httpMethod="PUT", notes="회원 금액 충전 API.")
	@PutMapping(value="/customer/info/charge/{cid}/{money}")
	public ResponseEntity<Object> chargeCustomerBalance(@PathVariable String cid, @PathVariable int money)
	{
		customerBillingService.chargeMoney(cid, money);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@ApiOperation(value = "회원 금액 결제", httpMethod="PUT", notes="회원 금액 결제 API.")
	@PutMapping(value="/customer/info/use/{cid}/{money}")
	public ResponseEntity<Object> useCustomerBalance(@PathVariable String cid, @PathVariable int money)
	{
		customerBillingService.useMoney(cid, money);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
