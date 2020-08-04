package com.example.demo.customer.core.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.customer.core.application.object.command.CustomerRequestDTO;
import com.example.demo.customer.core.entity.Customer;
import com.example.demo.customer.core.port_infra.persistent.CustomerRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class CustomerBillingService {
	
	@Autowired
	private final CustomerRepository customerRepository;
	private final ModelMapper modelMapper;
	
	public void chargeMoney(String cid, int money)
	{
		Optional<Customer> optionalCustomer = customerRepository.findById(cid);
		Customer customer = optionalCustomer.get();
		
		CustomerRequestDTO customerRequestDTO = modelMapper.map(optionalCustomer.get(), CustomerRequestDTO.class);
		int balance = customerRequestDTO.getBalance();
		balance = balance + money;
		customerRequestDTO.setBalance(balance);
		
		customer.update(customerRequestDTO);
		
	}
	
	public void useMoney(String cid, int money)
	{
		Optional<Customer> optionalCustomer = customerRepository.findById(cid);
		Customer customer = optionalCustomer.get();
		
		CustomerRequestDTO customerRequestDTO = modelMapper.map(optionalCustomer.get(), CustomerRequestDTO.class);
		int balance = customerRequestDTO.getBalance();
		balance = balance - money;
		customerRequestDTO.setBalance(balance);
		
		customer.update(customerRequestDTO);
		
	}

}
