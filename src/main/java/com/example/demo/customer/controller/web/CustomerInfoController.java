package com.example.demo.customer.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.customer.core.application.object.command.CustomerRequestDTO;
import com.example.demo.customer.core.application.object.query.ResponseDTO;
import com.example.demo.customer.core.service.CustomerInfoService;

import io.swagger.annotations.ApiOperation;

@RestController
public class CustomerInfoController {
	
	@Autowired
	CustomerInfoService customerInfoService;
	
	@ApiOperation(value="전체 회원 정보 조회", httpMethod = "GET", notes="전체 회원 정보 조회 API.")
	@GetMapping(value="/customer/info/all")
	public ResponseEntity<Object> getAllStore()
	{
		return new ResponseEntity<>(customerInfoService.getAllCustomer(),HttpStatus.OK);
	}
	
	@ApiOperation(value = "회원 정보 조회", httpMethod="GET", notes="회원 정보 조회 API.")
	@GetMapping(value="/customer/info/{cid}")
	public ResponseEntity<Object> getOneCustomer(@PathVariable String cid)
	{
		return new ResponseEntity<>(customerInfoService.getOneCustomer(cid), HttpStatus.OK);
	}
	
	@ApiOperation(value = "회원 정보 추가", httpMethod="POST", notes="회원 정보 추가 API")
	@PostMapping(value="/customer/info")
	public ResponseEntity<Object> addCustomer(@RequestBody CustomerRequestDTO customerRequestDTO)
	{
		customerInfoService.insertCustomer(customerRequestDTO);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@ApiOperation(value = "가게 정보 수정", httpMethod="PUT", notes="회원 정보 수정 API.")
	@PutMapping(value="/customer/info")
	public ResponseEntity<Object> updateCustomer(@RequestBody CustomerRequestDTO customerRequestDTO)
	{
		customerInfoService.updateCustomer(customerRequestDTO);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@ApiOperation(value = "회원 정보 삭제", httpMethod="DELETE", notes="회원 정보 삭제 API.")
	@DeleteMapping(value="/customer/info/{cid}")
	public ResponseEntity<Object> deleteCustomer(@PathVariable String cid)
	{
		customerInfoService.deleteCustomer(cid);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
