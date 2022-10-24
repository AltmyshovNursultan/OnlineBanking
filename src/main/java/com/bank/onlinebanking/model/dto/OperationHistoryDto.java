package com.bank.onlinebanking.model.dto;

import com.bank.onlinebanking.model.entity.Account;
import com.bank.onlinebanking.model.entity.User;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OperationHistoryDto {
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Date operationDate;
    String operationType;
    double amount;
    double commission;
    UserDto userId;
    AccountDto accountId;
    String receiverFirstName;
    String receiverLastName;
    String receiverAccount;
}
