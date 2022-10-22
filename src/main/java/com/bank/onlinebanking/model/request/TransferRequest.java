package com.bank.onlinebanking.model.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TransferRequest {
    String senderAccount;
    String receiverAccount;
    double amount;
}
