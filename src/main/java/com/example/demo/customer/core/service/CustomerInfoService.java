package com.example.demo.customer.core.service;

import java.util.List;

import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.demo.common.error.exception.BusinessException;
import com.example.demo.customer.core.application.object.command.CustomerRequestDTO;
import com.example.demo.customer.core.application.object.query.CustomerResponseDTO;
import com.example.demo.customer.core.entity.Customer;
import com.example.demo.customer.core.port_infra.persistent.CustomerRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class CustomerInfoService {
	private final CustomerRepository customerRepository;
	private final ModelMapper modelMapper;
	
	public List<Customer> getAllCustomer()
	{
		return customerRepository.findAll();
	}
	
	public CustomerResponseDTO getOneCustomer(String cid) //계속 주고 받는 것에 DTO를 쓰는 이유는 원래 객체를 망가뜨리지 않기 위해서 비슷한 것을 복제해 사용하는 것임
	{
		Optional<Customer> optionalCustomer = customerRepository.findById(cid);
		if(optionalCustomer.isPresent())
		{
			return modelMapper.map(optionalCustomer.get(), CustomerResponseDTO.class);
		}
		else
			return null;
	}
	
	public void insertCustomer(CustomerRequestDTO customerRequestDTO)
	{
		Customer customer = modelMapper.map(customerRequestDTO, Customer.class);
		customerRepository.save(customer);
	}
	
	public void updateCustomer(CustomerRequestDTO customerRequestDTO)	
	{
		Optional<Customer> optionalCustomer = customerRepository.findById(customerRequestDTO.getCid());
		if(!optionalCustomer.isPresent())
		{
			throw new BusinessException("0000","There is No Customer");
		}
		Customer customer = optionalCustomer.get();
		customer.update(customerRequestDTO);
		customerRepository.save(customer);
	}
	
	public void deleteCustomer(String cid)
	{
		Optional<Customer> optionalCustomer = customerRepository.findById(cid);
		if(!optionalCustomer.isPresent())
		{
			throw new BusinessException("0000","There is No Customer");
		}
		customerRepository.delete(optionalCustomer.get());
	}

}
