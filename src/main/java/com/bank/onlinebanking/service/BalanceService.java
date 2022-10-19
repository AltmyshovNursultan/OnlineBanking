package com.bank.onlinebanking.service;

import com.bank.onlinebanking.model.dto.BalanceDto;

public interface BalanceService {
    BalanceDto createBalance (double amount, double reservedAmount);
}
