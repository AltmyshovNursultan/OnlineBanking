package com.bank.onlinebanking.service;

import com.bank.onlinebanking.model.dto.AccountDto;
import com.bank.onlinebanking.model.entity.User;
import com.bank.onlinebanking.model.request.LoginRequest;
import com.bank.onlinebanking.model.response.AccountResponse;
import com.bank.onlinebanking.model.response.LoginResponse;
import com.bank.onlinebanking.model.response.UserResponse;

import java.util.List;

public interface AccountService{
    UserResponse createAccount(String firstName, String lastName,
                               String phoneNumber, String password,
                               String accountNumber, double amount,
                               double reservedAccount);

    List<AccountResponse> accountResponse(User userId);
    LoginResponse loginUser(LoginRequest loginRequest);
}
