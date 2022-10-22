package com.bank.onlinebanking.service;

import com.bank.onlinebanking.model.dto.BalanceDto;
import com.bank.onlinebanking.model.entity.Account;
import com.bank.onlinebanking.model.entity.Balance;

public interface BalanceService {
    BalanceDto createBalance (double amount, double reservedAmount);

    Balance addMoney(Balance balance, double amount);

    Balance subtract(Balance balance, double amount);
}
