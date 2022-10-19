package com.bank.onlinebanking.model.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "accounts")
public class Account {
    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String accountNumber;
    @ManyToOne(cascade = {CascadeType.ALL})
        @JoinColumn(name = "user_id")
    User userId;
    @ManyToOne
            @JoinColumn(name = "balance_id")
    Balance balance;
}
