package com.bank.onlinebanking.service.impls;

import com.bank.onlinebanking.dao.OperationHistoryRepo;
import com.bank.onlinebanking.mapper.OperationHistoryMapper;
import com.bank.onlinebanking.model.dto.OperationHistoryDto;
import com.bank.onlinebanking.model.entity.Account;
import com.bank.onlinebanking.model.entity.OperationHistory;
import com.bank.onlinebanking.model.request.TransferRequest;
import com.bank.onlinebanking.model.response.TransferResponse;
import com.bank.onlinebanking.service.AccountService;
import com.bank.onlinebanking.service.OperationHistoryService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OperationHistoryServiceImpl implements OperationHistoryService {
    private final OperationHistoryRepo operationHistoryRepo;
    private final AccountService accountService;
    private final OperationHistoryMapper operationHistoryMapper;

    public OperationHistoryServiceImpl(OperationHistoryRepo operationHistoryRepo, AccountService accountService) {
        this.operationHistoryRepo = operationHistoryRepo;
        this.accountService = accountService;
        this.operationHistoryMapper = OperationHistoryMapper.INSTANCE;
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
        double commission = (transferRequest.getAmount()/100)*1;
        // Save all data in operation history for sender
        OperationHistory operationHistory = new OperationHistory();
        operationHistory.setUserId(senderAccount.getUserId());
        operationHistory.setOperationDate(new Date());
        operationHistory.setAmount(transferRequest.getAmount());
        operationHistory.setAccountId(senderAccount);
        operationHistory.setOperationType("Transfer");
        operationHistory.setCommission(commission);
        operationHistory.setReceiverAccount(receiverAccount.getAccountNumber());
        operationHistory.setReceiverLastName(receiverAccount.getUserId().getLastName());
        operationHistory.setReceiverFirstName(receiverAccount.getUserId().getFirstName());
        operationHistoryRepo.save(operationHistory);

        // Save all data in operation history for receiver
        OperationHistory operationHistory1 = new OperationHistory();
        operationHistory1.setUserId(receiverAccount.getUserId());
        operationHistory1.setOperationDate(new Date());
        operationHistory1.setOperationType("Refill");
        operationHistory1.setAmount(transferRequest.getAmount());
        operationHistory1.setReceiverLastName(senderAccount.getUserId().getLastName());
        operationHistory1.setReceiverFirstName(senderAccount.getUserId().getFirstName());
        operationHistory1.setReceiverAccount(senderAccount.getAccountNumber());
        operationHistory1.setCommission(0);
        operationHistoryRepo.save(operationHistory1);

        TransferResponse transferResponse = new TransferResponse();
        transferResponse.setSenderAccount(senderAccount.getAccountNumber());
        transferResponse.setReceiverAccount(receiverAccount.getAccountNumber());
        transferResponse.setSenderFirstName(senderAccount.getUserId().getFirstName());
        transferResponse.setSenderLastName(senderAccount.getUserId().getLastName());
        transferResponse.setReceiverFirstName(receiverAccount.getUserId().getFirstName());
        transferResponse.setReceiverLastName(receiverAccount.getUserId().getLastName());
        transferResponse.setAmount(transferRequest.getAmount());
        transferResponse.setTransactionDate(new Date());
        transferResponse.setCommission(commission);
        return transferResponse;

    }

    @Override
    public List<OperationHistoryDto> getHistory(String accountNumber) {
        List<OperationHistory> operationHistory = operationHistoryRepo.findOperationHistoriesByAccountId_AccountNumber(accountNumber);
        return operationHistoryMapper.toDtos(operationHistory);
    }
}
