package com.bank.onlinebanking.model.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "operation_history")
public class OperationHistory {
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Date operationDate;
    String operationType;
    double amount;
    double commission;
    @ManyToOne
        @JoinColumn(name = "user_id")
    User userId;
    @ManyToOne
        @JoinColumn(name = "account_id")
    Account accountId;
    String receiverFirstName;
    String receiverLastName;
    String receiverAccount;
}
