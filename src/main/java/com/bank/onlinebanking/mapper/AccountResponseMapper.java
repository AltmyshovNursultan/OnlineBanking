package com.bank.onlinebanking.mapper;

import com.bank.onlinebanking.mapper.base.CrudMethod;
import com.bank.onlinebanking.model.entity.Account;
import com.bank.onlinebanking.model.response.AccountResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AccountResponseMapper extends CrudMethod<Account, AccountResponse> {
    AccountResponseMapper INSTANCE = Mappers.getMapper(AccountResponseMapper.class);
}
