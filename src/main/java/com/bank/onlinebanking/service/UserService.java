package com.bank.onlinebanking.service;

import com.bank.onlinebanking.model.dto.UserDto;

public interface UserService {
    public UserDto createUser(String firstName, String lastName, String password, String phoneNumber);
}
