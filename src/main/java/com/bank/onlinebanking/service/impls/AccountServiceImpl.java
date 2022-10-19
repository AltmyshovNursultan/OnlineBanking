package com.bank.onlinebanking.service.impls;

import com.bank.onlinebanking.dao.AccountRepo;
import com.bank.onlinebanking.mapper.AccountMapper;
import com.bank.onlinebanking.mapper.BalanceMapper;
import com.bank.onlinebanking.mapper.UserMapper;
import com.bank.onlinebanking.model.dto.AccountDto;
import com.bank.onlinebanking.model.dto.BalanceDto;
import com.bank.onlinebanking.model.dto.UserDto;
import com.bank.onlinebanking.model.entity.Account;
import com.bank.onlinebanking.model.entity.Balance;
import com.bank.onlinebanking.model.entity.User;
import com.bank.onlinebanking.service.AccountService;
import com.bank.onlinebanking.service.BalanceService;
import com.bank.onlinebanking.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepo accountRepo;
    private final AccountMapper accountMapper;
    private final UserMapper userMapper;
    private final BalanceMapper balanceMapper;
    private final UserService userService;
    private final BalanceService balanceService;


    public AccountServiceImpl(AccountRepo accountRepo,UserService userService, BalanceService balanceService) {
        this.accountRepo = accountRepo;
        this.balanceMapper = BalanceMapper.INSTANCE;
        this.userMapper = UserMapper.INSTANCE;
        this.userService = userService;
        this.balanceService = balanceService;
        this.accountMapper = AccountMapper.INSTANCE;
    }
    @Override
    public AccountDto createAccount(String firstName, String lastName,
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
        System.out.println(account);
        return accountMapper.toDto(account);
    }
}
