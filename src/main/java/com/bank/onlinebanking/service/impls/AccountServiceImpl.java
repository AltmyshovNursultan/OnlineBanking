package com.bank.onlinebanking.service.impls;

import com.bank.onlinebanking.dao.AccountRepo;
import com.bank.onlinebanking.mapper.AccountMapper;
import com.bank.onlinebanking.mapper.AccountResponseMapper;
import com.bank.onlinebanking.mapper.BalanceMapper;
import com.bank.onlinebanking.mapper.UserMapper;
import com.bank.onlinebanking.model.dto.BalanceDto;
import com.bank.onlinebanking.model.dto.UserDto;
import com.bank.onlinebanking.model.entity.Account;
import com.bank.onlinebanking.model.entity.Balance;
import com.bank.onlinebanking.model.entity.User;
import com.bank.onlinebanking.model.request.LoginRequest;
import com.bank.onlinebanking.model.response.AccountResponse;
import com.bank.onlinebanking.model.response.LoginResponse;
import com.bank.onlinebanking.model.response.UserResponse;
import com.bank.onlinebanking.service.AccountService;
import com.bank.onlinebanking.service.BalanceService;
import com.bank.onlinebanking.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepo accountRepo;
    private final AccountMapper accountMapper;
    private final UserMapper userMapper;
    private final BalanceMapper balanceMapper;
    private final UserService userService;
    private final BalanceService balanceService;
    private final AccountResponseMapper accountResponseMapper;


    public AccountServiceImpl(AccountRepo accountRepo, UserService userService, BalanceService balanceService) {
        this.accountRepo = accountRepo;
        this.accountResponseMapper = AccountResponseMapper.INSTANCE;
        this.balanceMapper = BalanceMapper.INSTANCE;
        this.userMapper = UserMapper.INSTANCE;
        this.userService = userService;
        this.balanceService = balanceService;
        this.accountMapper = AccountMapper.INSTANCE;
    }
    @Override
    public UserResponse createAccount(String firstName, String lastName,
                                      String phoneNumber, String password,
                                      String accountNumber, double amount,
                                      double reservedAmount){
        UserDto userDto = userService.createUser(firstName,lastName,phoneNumber,password);
        User user = userMapper.toEntity(userDto);
        BalanceDto balanceDto = balanceService.createBalance(amount, reservedAmount);
        Balance balance = balanceMapper.toEntity(balanceDto);

        Account account = new Account();
        account.setAccountNumber(accountNumber);
        account.setUserId(user);
        account.setBalance(balance);
        accountRepo.save(account);

        UserResponse userResponse = new UserResponse();
        userResponse.setUser(user);
        userResponse.setAccount(account);
        userResponse.setBalance(balance);
        return userResponse;
    }

    @Override
    public List<AccountResponse> accountResponse(User userId) {
        List<Account> accounts = accountRepo.getAccountByUserId(userId);
        List<AccountResponse> accountResponses = accountResponseMapper.toDtos(accounts);
        return accountResponses;
    }
    @Override
    public LoginResponse loginUser(LoginRequest loginRequest) {
        User user = userService.findUserByPhoneNumber(loginRequest.getUserNumber());
        LoginResponse loginResponse = new LoginResponse();
        if (user == null){
            System.out.println("This login does not exist!");
        } else if (!(user.equals(loginRequest.getPassword()))) {
            System.out.println("This password is incorrect");
        }
        List<AccountResponse> accountResponses = accountResponse(user);
        loginResponse.setAccountResponsesList(accountResponses);
        loginResponse.setFirstName(user.getFirstName());
        loginResponse.setLastName(user.getLastName());
        return loginResponse;
    }
}
