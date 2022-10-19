package com.bank.onlinebanking.service.impls;

import com.bank.onlinebanking.dao.BalanceRepo;
import com.bank.onlinebanking.mapper.BalanceMapper;
import com.bank.onlinebanking.model.dto.BalanceDto;
import com.bank.onlinebanking.model.entity.Balance;
import com.bank.onlinebanking.service.BalanceService;
import org.springframework.stereotype.Service;

@Service
public class BalanceServiceImpl implements BalanceService {
    private final BalanceRepo balanceRepo;
    private final BalanceMapper balanceMapper;
    public BalanceServiceImpl(BalanceRepo balanceRepo) {
        this.balanceRepo = balanceRepo;
        this.balanceMapper = BalanceMapper.INSTANCE;
    }

    @Override
    public BalanceDto createBalance(double amount, double reservedAmount) {
        Balance balance = new Balance();
        balance.setAmount(amount);
        balance.setReservedAmount(reservedAmount);
        balanceRepo.save(balance);
        return balanceMapper.toDto(balance);
    }
}
