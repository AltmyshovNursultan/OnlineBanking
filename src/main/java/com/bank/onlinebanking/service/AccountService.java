package com.bank.onlinebanking.service;

import com.bank.onlinebanking.model.entity.Account;
import com.bank.onlinebanking.model.entity.User;
import com.bank.onlinebanking.model.request.LoginRequest;
import com.bank.onlinebanking.model.response.AccountResponse;
import com.bank.onlinebanking.model.response.AddedAccountResponse;
import com.bank.onlinebanking.model.response.LoginResponse;
import com.bank.onlinebanking.model.response.UserResponse;

import java.util.List;

public interface AccountService{
    UserResponse createAccount(String firstName, String lastName,
                               String phoneNumber, String password,
                               String accountNumber, String currency, double amount,
                               double reservedAccount);

    List<AccountResponse> accountResponse(User userId);
    LoginResponse loginUser(LoginRequest loginRequest);

    Account findByAccountNumber(String accountNumber);

    Account sendMoney(Account senderAccount, double amount);

    Account receiveMoney(Account receiverAccount, double amount);

    AddedAccountResponse addAccount(String userPhone, String accountNumber,
                                    double amount, double reservedAmount, String currency);
}
