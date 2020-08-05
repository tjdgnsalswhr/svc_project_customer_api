package com.example.demo.customer.core.port_infra.persistent;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.customer.core.entity.Balance;

public interface BalanceRepository extends JpaRepository<Balance, String> {

	public Optional<Balance> findByCidAndSid(String cid, String sid);
}
