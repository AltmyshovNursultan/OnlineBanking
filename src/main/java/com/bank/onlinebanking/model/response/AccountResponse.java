package com.bank.onlinebanking.model.response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountResponse {
    String accountNumber;
    double amount;
}
