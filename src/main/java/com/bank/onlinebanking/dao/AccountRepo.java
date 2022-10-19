package com.bank.onlinebanking.dao;

import com.bank.onlinebanking.model.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository<Account, Long> {
}
