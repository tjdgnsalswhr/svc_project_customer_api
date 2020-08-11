package com.example.demo.customer.controller.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.customer.core.application.object.command.CustomerRequestDTO;
import com.example.demo.customer.core.service.BillingService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin("*")
@RestController
public class BillingController {
	
	@Autowired
	BillingService billingService;
	
	@ApiOperation(value = "회원 금액 충전", httpMethod="PUT", notes="회원 금액 충전 API.")
	@PutMapping(value="/billing/charge/{cid}/{sid}/{money}")
	public ResponseEntity<Object> chargeBalance(@PathVariable String cid, @PathVariable String sid, @PathVariable int money)
	{
		billingService.chargeMoney(cid, sid, money);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@ApiOperation(value = "회원 금액 결제", httpMethod="PUT", notes="회원 금액 결제 API.")
	@PutMapping(value="/billing/use/{cid}/{sid}/{money}")
	public ResponseEntity<Object> useBalance(@PathVariable String cid, @PathVariable String sid, @PathVariable int money)
	{
		billingService.useMoney(cid, sid, money);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
