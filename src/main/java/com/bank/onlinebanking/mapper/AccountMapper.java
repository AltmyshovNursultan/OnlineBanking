package com.bank.onlinebanking.mapper;

import com.bank.onlinebanking.mapper.base.CrudMethod;
import com.bank.onlinebanking.model.dto.AccountDto;
import com.bank.onlinebanking.model.dto.BalanceDto;
import com.bank.onlinebanking.model.entity.Account;
import com.bank.onlinebanking.model.entity.Balance;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AccountMapper  {
    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);
    @Mapping(source = "balance.amount", target = "amount")
    AccountDto toDto(Account account);
    @Mapping(source = "balance.amount", target = "amount")
    List<AccountDto> toDtos(List<Account> accounts);
}
