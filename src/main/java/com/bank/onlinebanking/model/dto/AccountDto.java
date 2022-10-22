package com.bank.onlinebanking.model.dto;

import com.bank.onlinebanking.model.entity.User;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountDto {
    Long id;
    String accountNumber;
    String currency;
    UserDto userDto;
    BalanceDto balanceDto;
}
