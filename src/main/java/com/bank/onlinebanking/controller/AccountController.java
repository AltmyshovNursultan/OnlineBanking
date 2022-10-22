package com.bank.onlinebanking.controller;

import com.bank.onlinebanking.model.request.LoginRequest;
import com.bank.onlinebanking.model.response.LoginResponse;
import com.bank.onlinebanking.model.response.UserResponse;
import com.bank.onlinebanking.service.AccountService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
    @PostMapping("createAccount")
    public UserResponse createAccount (@RequestParam String firstName,
                                       @RequestParam String lastName,
                                       @RequestParam String phoneNumber,
                                       @RequestParam String password,
                                       @RequestParam String accountNumber,
                                       @RequestParam double amount,
                                       @RequestParam double reservedAmount){
        return accountService.createAccount(firstName,lastName,phoneNumber,password,
                                            accountNumber,amount,reservedAmount);
    }
    @GetMapping("/login")
    public LoginResponse loginUser(@RequestBody LoginRequest loginRequest){
        return accountService.loginUser(loginRequest);
    }
}
