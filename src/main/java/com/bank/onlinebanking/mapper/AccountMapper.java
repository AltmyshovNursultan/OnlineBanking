package com.bank.onlinebanking.mapper;

import com.bank.onlinebanking.mapper.base.CrudMethod;
import com.bank.onlinebanking.model.dto.AccountDto;
import com.bank.onlinebanking.model.entity.Account;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AccountMapper extends CrudMethod<Account, AccountDto> {
    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

}
