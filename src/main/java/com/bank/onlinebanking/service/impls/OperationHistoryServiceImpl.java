package com.bank.onlinebanking.service.impls;

import com.bank.onlinebanking.dao.OperationHistoryRepo;
import com.bank.onlinebanking.model.entity.Account;
import com.bank.onlinebanking.model.entity.OperationHistory;
import com.bank.onlinebanking.model.request.TransferRequest;
import com.bank.onlinebanking.model.response.TransferResponse;
import com.bank.onlinebanking.service.AccountService;
import com.bank.onlinebanking.service.OperationHistoryService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OperationHistoryServiceImpl implements OperationHistoryService {
    private final OperationHistoryRepo operationHistoryRepo;
    private final AccountService accountService;

    public OperationHistoryServiceImpl(OperationHistoryRepo operationHistoryRepo, AccountService accountService) {
        this.operationHistoryRepo = operationHistoryRepo;
        this.accountService = accountService;
    }

    @Override
    public TransferResponse transfer(TransferRequest transferRequest) {
        Account senderAccount = accountService.findByAccountNumber(transferRequest.getSenderAccount());
        if (senderAccount==null){
            throw new RuntimeException("No such a user exists!");
        }
        Account receiverAccount = accountService.findByAccountNumber(transferRequest.getReceiverAccount());
        if (receiverAccount==null || receiverAccount.equals(senderAccount)){
            throw new RuntimeException("No such a user exists or invalid user!");
        }
        senderAccount = accountService.sendMoney(senderAccount,transferRequest.getAmount());
        receiverAccount = accountService.receiveMoney(receiverAccount, transferRequest.getAmount());

        OperationHistory operationHistory = new OperationHistory();
        operationHistory.setUserId(senderAccount.getUserId());
        operationHistory.setOperationDate(new Date());
        operationHistory.setAmount(transferRequest.getAmount());
        operationHistory.setAccountId(senderAccount);
        operationHistory.setOperationType("Transfer");
        operationHistoryRepo.save(operationHistory);

        TransferResponse transferResponse = new TransferResponse();
        transferResponse.setSenderAccount(senderAccount.getAccountNumber());
        transferResponse.setReceiverAccount(receiverAccount.getAccountNumber());
        transferResponse.setSenderFirstName(senderAccount.getUserId().getFirstName());
        transferResponse.setSenderLastName(senderAccount.getUserId().getLastName());
        transferResponse.setReceiverFirstName(receiverAccount.getUserId().getFirstName());
        transferResponse.setReceiverLastName(receiverAccount.getUserId().getLastName());
        transferResponse.setAmount(transferRequest.getAmount());
        transferResponse.setTransactionDate(new Date());
        return transferResponse;

    }
}
