package com.bank.onlinebanking.model.response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AddedAccountResponse {
    String firstName;
    String lastName;
    String newAccount;
    String currency;
    double amount;
}
