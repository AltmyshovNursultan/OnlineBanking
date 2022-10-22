
package com.bank.onlinebanking.controller;

import com.bank.onlinebanking.model.request.TransferRequest;
import com.bank.onlinebanking.model.response.TransferResponse;
import com.bank.onlinebanking.service.OperationHistoryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/operation")
public class OperationHistoryController {
    private final OperationHistoryService operationHistoryService;

    public OperationHistoryController(OperationHistoryService operationHistoryService) {
        this.operationHistoryService = operationHistoryService;
    }

    @PostMapping("/transfer")
    public TransferResponse transfer(@RequestBody TransferRequest transferRequest){
        return operationHistoryService.transfer(transferRequest);
    }
}

