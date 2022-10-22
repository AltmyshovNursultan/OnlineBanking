package com.bank.onlinebanking.service;

import com.bank.onlinebanking.model.request.TransferRequest;
import com.bank.onlinebanking.model.response.TransferResponse;

public interface OperationHistoryService {
    TransferResponse transfer(TransferRequest transferRequest);
}
