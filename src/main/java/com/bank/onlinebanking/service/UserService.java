package com.bank.onlinebanking.service;

import com.bank.onlinebanking.model.dto.UserDto;
import com.bank.onlinebanking.model.entity.User;
import com.bank.onlinebanking.model.request.LoginRequest;
import com.bank.onlinebanking.model.response.LoginResponse;
import com.bank.onlinebanking.model.response.UpdatedUserResponse;

public interface UserService {
    public UserDto createUser(String firstName, String lastName, String password, String phoneNumber);

    User findUserByPhoneNumber(String userNumber);

    UpdatedUserResponse updatePassword(String phoneNumber, String password);
}
