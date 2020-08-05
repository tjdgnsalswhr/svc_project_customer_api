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

import com.example.demo.customer.core.application.object.command.BalanceRequestDTO;
import com.example.demo.customer.core.application.object.command.CustomerRequestDTO;
import com.example.demo.customer.core.service.BalanceInfoService;

import io.swagger.annotations.ApiOperation;

@RestController
public class BalanceInfoController {
	
	@Autowired
	BalanceInfoService balanceInfoService;
	
	@ApiOperation(value="전체 잔액 정보 조회", httpMethod = "GET", notes="전체 잔액 정보 조회 API.")
	@GetMapping(value="/balance/info/all")
	public ResponseEntity<Object> getAllBalance()
	{
		return new ResponseEntity<>(balanceInfoService.getAllBalance(),HttpStatus.OK);
	}
	
	@ApiOperation(value = "잔액 정보 조회", httpMethod="GET", notes="잔액 정보 조회 API.")
	@GetMapping(value="/balance/info/{cid}/{sid}")
	public ResponseEntity<Object> getOneBalance(@PathVariable String cid, @PathVariable String sid)
	{
		return new ResponseEntity<>(balanceInfoService.getOneBalance(cid, sid), HttpStatus.OK);
	}
	
	@ApiOperation(value = "잔액 정보 추가", httpMethod="POST", notes="잔액 정보 추가 API")
	@PostMapping(value="/balance/info")
	public ResponseEntity<Object> addBalance(@RequestBody BalanceRequestDTO balanceRequestDTO)
	{
		balanceInfoService.insertBalance(balanceRequestDTO);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@ApiOperation(value = "잔액 정보 수정", httpMethod="PUT", notes="잔액 정보 수정 API.")
	@PutMapping(value="/balance/info")
	public ResponseEntity<Object> updateBalance(@RequestBody BalanceRequestDTO balanceRequestDTO)
	{
		balanceInfoService.updateBalance(balanceRequestDTO);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@ApiOperation(value = "잔액 정보 삭제", httpMethod="DELETE", notes="잔액 정보 삭제 API.")
	@DeleteMapping(value="/balance/info/{cid}/{sid}")
	public ResponseEntity<Object> deleteBalance(@PathVariable String cid, @PathVariable String sid)
	{
		balanceInfoService.deleteBalance(cid, sid);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
