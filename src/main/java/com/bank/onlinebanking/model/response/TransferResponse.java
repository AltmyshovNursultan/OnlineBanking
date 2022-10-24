package com.bank.onlinebanking.model.response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TransferResponse {
    String senderAccount;
    String senderFirstName;
    String senderLastName;
    String receiverAccount;
    String receiverFirstName;
    String receiverLastName;
    double amount;
    Date transactionDate;
    double commission;
}
