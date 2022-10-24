package com.bank.onlinebanking.service;

import com.bank.onlinebanking.model.dto.OperationHistoryDto;
import com.bank.onlinebanking.model.request.TransferRequest;
import com.bank.onlinebanking.model.response.TransferResponse;

import java.util.List;

public interface OperationHistoryService {
    TransferResponse transfer(TransferRequest transferRequest);
    List<OperationHistoryDto> getHistory(String accountNumber);

}
