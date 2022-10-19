package com.bank.onlinebanking.dao;

import com.bank.onlinebanking.model.entity.OperationHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationHistoryRepo extends JpaRepository<OperationHistory, Long> {
}
