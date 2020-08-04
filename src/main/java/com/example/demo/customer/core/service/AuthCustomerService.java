package com.example.demo.customer.core.service;

import java.util.Optional;


import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.customer.core.entity.Customer;
import com.example.demo.customer.core.port_infra.persistent.CustomerRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class AuthCustomerService {
	
	@Autowired
	private final CustomerRepository customerRepository;
	private final ModelMapper modelMapper;
	
	public boolean authCustomer(String cId, String cPassword)
	{
		Optional<Customer> optionalCustomer = customerRepository.findById(cId);
		if(!optionalCustomer.isPresent())
		{
			//만약 id에 해당하는 객체가 Repository에 없다면 인증 실패
			return false;
		}
		else
		{
			Customer customer = optionalCustomer.get();
			if(cPassword.equals(customer.getCpassword()))
			{
				//일치하는 아이디가 있고 그 비밀번호까지 맞다면 인증 성공
				return true;
			}
			else
				return false;
		}
	}

}
