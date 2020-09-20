package com.mycompany.myapp.service.mapper;


import com.mycompany.myapp.domain.*;
import com.mycompany.myapp.service.dto.TransactionEntityDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link TransactionEntity} and its DTO {@link TransactionEntityDTO}.
 */
@Mapper(componentModel = "spring", uses = {AccountEntityMapper.class})
public interface TransactionEntityMapper extends EntityMapper<TransactionEntityDTO, TransactionEntity> {

    @Mapping(source = "accountEntity.id", target = "accountEntityId")
    @Mapping(source = "accountEntity.code", target = "accountEntityCode")
    TransactionEntityDTO toDto(TransactionEntity transactionEntity);

    @Mapping(source = "accountEntityId", target = "accountEntity")
    TransactionEntity toEntity(TransactionEntityDTO transactionEntityDTO);

    default TransactionEntity fromId(Long id) {
        if (id == null) {
            return null;
        }
        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setId(id);
        return transactionEntity;
    }
}
