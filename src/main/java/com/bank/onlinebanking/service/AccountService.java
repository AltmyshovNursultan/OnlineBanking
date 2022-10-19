package com.bank.onlinebanking.service;

import com.bank.onlinebanking.model.dto.AccountDto;

public interface AccountService{
    AccountDto createAccount(String firstName, String lastName,
                             String phoneNumber, String password,
                             String accountNumber, double amount,
                             double reservedAccount);
}
