package com.bank.onlinebanking.dao;

import com.bank.onlinebanking.model.entity.Account;
import com.bank.onlinebanking.model.entity.OperationHistory;
import com.bank.onlinebanking.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OperationHistoryRepo extends JpaRepository<OperationHistory, Long> {

    List<OperationHistory> findOperationHistoriesByAccountId_AccountNumber(String accountNumber);

}
