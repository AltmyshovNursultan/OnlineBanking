package com.bank.onlinebanking.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OperationHistoryMapper {
    OperationHistoryMapper INSTANCE = Mappers.getMapper(OperationHistoryMapper.class);

}
