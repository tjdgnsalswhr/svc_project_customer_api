package com.example.demo.customer.core.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.customer.core.application.object.command.BalanceRequestDTO;
import com.example.demo.customer.core.application.object.command.CustomerRequestDTO;
import com.example.demo.customer.core.entity.Balance;
import com.example.demo.customer.core.entity.Customer;
import com.example.demo.customer.core.port_infra.persistent.BalanceRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class BillingService {
	
	@Autowired
	private final BalanceRepository balanceRepository;
	private final ModelMapper modelMapper;
	
	public void chargeMoney(String cid, String sid, int money)
	{
		Optional<Balance> optionalBalance = balanceRepository.findByCidAndSid(cid, sid);
		Balance balance = optionalBalance.get();
		
		BalanceRequestDTO balanceRequestDTO = modelMapper.map(optionalBalance.get(), BalanceRequestDTO.class);
		int nbalance = balanceRequestDTO.getBmoney();
		nbalance = nbalance + money;
		balanceRequestDTO.setBmoney(nbalance);
		
		balance.update(balanceRequestDTO);
		
	}
	
	public void useMoney(String cid, String sid, int money)
	{
		Optional<Balance> optionalBalance = balanceRepository.findByCidAndSid(cid, sid);
		Balance balance = optionalBalance.get();
		
		BalanceRequestDTO balanceRequestDTO = modelMapper.map(optionalBalance.get(), BalanceRequestDTO.class);
		int nbalance = balanceRequestDTO.getBmoney();
		nbalance = nbalance - money;
		balanceRequestDTO.setBmoney(nbalance);
		
		balance.update(balanceRequestDTO);
		
	}

}
