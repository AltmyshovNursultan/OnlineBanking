package com.bank.onlinebanking.dao;

import com.bank.onlinebanking.model.entity.Balance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BalanceRepo extends JpaRepository<Balance, Long> {
}
