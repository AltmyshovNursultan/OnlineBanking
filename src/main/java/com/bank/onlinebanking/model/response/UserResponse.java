package com.bank.onlinebanking.model.response;

import com.bank.onlinebanking.model.entity.Account;
import com.bank.onlinebanking.model.entity.Balance;
import com.bank.onlinebanking.model.entity.User;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {
    Account account;
    Balance balance;
    User user;
}
