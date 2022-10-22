package com.bank.onlinebanking.model.response;

import com.bank.onlinebanking.model.entity.Account;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoginResponse {
    String firstName;
    String lastName;
    List<AccountResponse> accountResponsesList;
}
