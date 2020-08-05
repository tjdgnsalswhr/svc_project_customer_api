package com.example.demo.customer.core.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.demo.common.error.exception.BusinessException;
import com.example.demo.customer.core.application.object.command.BalanceRequestDTO;
import com.example.demo.customer.core.application.object.command.CustomerRequestDTO;
import com.example.demo.customer.core.application.object.query.BalanceResponseDTO;
import com.example.demo.customer.core.entity.Balance;
import com.example.demo.customer.core.port_infra.persistent.BalanceRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class BalanceInfoService {
	private final BalanceRepository balanceRepository;
	private final ModelMapper modelMapper;
	
	public List<Balance> getAllBalance()
	{
		return balanceRepository.findAll();
	}
	
	public BalanceResponseDTO getOneBalance(String cid, String sid) //계속 주고 받는 것에 DTO를 쓰는 이유는 원래 객체를 망가뜨리지 않기 위해서 비슷한 것을 복제해 사용하는 것임
	{
		Optional<Balance> optionalBalance = balanceRepository.findByCidAndSid(cid, sid);
		if(optionalBalance.isPresent())
		{
			return modelMapper.map(optionalBalance.get(), BalanceResponseDTO.class);
		}
		else
			return null;
	}
	
	public void insertBalance(BalanceRequestDTO balanceRequestDTO)
	{
		Balance balance = modelMapper.map(balanceRequestDTO, Balance.class);
		balanceRepository.save(balance);
	}
	
	public void updateBalance(BalanceRequestDTO balanceRequestDTO)	
	{
		Optional<Balance> optionalBalance = balanceRepository.findById(balanceRequestDTO.getCid());
		if(!optionalBalance.isPresent())
		{
			throw new BusinessException("0000","There is No Connection");
		}
		Balance balance = optionalBalance.get();
		balance.update(balanceRequestDTO);
		balanceRepository.save(balance);
	}
	
	public void deleteBalance(String cid, String sid)
	{
		Optional<Balance> optionalBalance = balanceRepository.findByCidAndSid(cid, sid);
		if(!optionalBalance.isPresent())
		{
			throw new BusinessException("0000","There is No Connection");
		}
		balanceRepository.delete(optionalBalance.get());
	}

}
