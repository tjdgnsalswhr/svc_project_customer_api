package com.example.demo.customer.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.customer.core.application.object.command.CustomerRequestDTO;
import com.example.demo.customer.core.service.AuthCustomerService;

import io.swagger.annotations.ApiOperation;

@RestController
public class AuthCustomerController {
	@Autowired //자동주입
	AuthCustomerService authCustomerService;
	
	@ApiOperation(value = "회원 정보 인증", httpMethod="POST", notes = "회원 정보 인증 API.")
	@PostMapping(value="/customer/auth")
	public ResponseEntity<Object> authCustomer(@RequestBody CustomerRequestDTO customerRequestDTO)
	{
		return new ResponseEntity<>(authCustomerService.authCustomer(customerRequestDTO.getCid(), customerRequestDTO.getCpassword()), HttpStatus.OK);
	}

}
