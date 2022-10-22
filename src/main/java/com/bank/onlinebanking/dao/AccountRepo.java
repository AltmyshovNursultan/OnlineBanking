package com.bank.onlinebanking.dao;

import com.bank.onlinebanking.model.entity.Account;
import com.bank.onlinebanking.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepo extends JpaRepository<Account, Long> {
    List<Account> getAccountByUserId(User userId);
}
