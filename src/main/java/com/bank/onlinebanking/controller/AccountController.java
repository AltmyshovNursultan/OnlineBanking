package com.bank.onlinebanking.controller;

import com.bank.onlinebanking.model.dto.AccountDto;
import com.bank.onlinebanking.service.AccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
    @PostMapping("createAccount")
    public AccountDto createAccount (@RequestParam String firstName,
                                     @RequestParam String lastName,
                                     @RequestParam String phoneNumber,
                                     @RequestParam String password,
                                     @RequestParam String accountNumber,
                                     @RequestParam double amount,
                                     @RequestParam double reservedAmount){
        return accountService.createAccount(firstName,lastName,phoneNumber,password,
                                            accountNumber,amount,reservedAmount);
    }
}
