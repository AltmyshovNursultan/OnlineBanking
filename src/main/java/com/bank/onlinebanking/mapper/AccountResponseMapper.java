package com.bank.onlinebanking.mapper;

import com.bank.onlinebanking.mapper.base.CrudMethod;
import com.bank.onlinebanking.model.entity.Account;
import com.bank.onlinebanking.model.response.AccountResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AccountResponseMapper {
    AccountResponseMapper INSTANCE = Mappers.getMapper(AccountResponseMapper.class);

    @Mapping(source = "amount",target = "balance.amount")
    List<AccountResponse> toDtos(List<Account> e);

}
