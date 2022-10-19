package com.bank.onlinebanking.model.dto;

import com.bank.onlinebanking.model.entity.Account;
import com.bank.onlinebanking.model.entity.User;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OperationHistoryDto {
    Long id;
    Date operationDate;
    String operationType;
    double amount;
    UserDto userDto;
    Account accountId;
}
