package com.bank.onlinebanking.mapper;

import com.bank.onlinebanking.mapper.base.CrudMethod;
import com.bank.onlinebanking.model.dto.UserDto;
import com.bank.onlinebanking.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper extends CrudMethod<User, UserDto> {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

}
