package com.bank.onlinebanking.mapper;

import com.bank.onlinebanking.mapper.base.CrudMethod;
import com.bank.onlinebanking.model.dto.OperationHistoryDto;
import com.bank.onlinebanking.model.entity.OperationHistory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OperationHistoryMapper extends CrudMethod<OperationHistory, OperationHistoryDto> {
    OperationHistoryMapper INSTANCE = Mappers.getMapper(OperationHistoryMapper.class);

    @Mapping(source = "amount", target = "accountId.amount")
    @Mapping(source = "accountId.accountNumber",target = "accountId")
    OperationHistoryDto toDto(OperationHistory operationHistory);



    List<OperationHistoryDto> toDtos(List<OperationHistory> e);
}
