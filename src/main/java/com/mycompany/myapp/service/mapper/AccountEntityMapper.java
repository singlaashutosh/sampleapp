package com.mycompany.myapp.service.mapper;


import com.mycompany.myapp.domain.*;
import com.mycompany.myapp.service.dto.AccountEntityDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link AccountEntity} and its DTO {@link AccountEntityDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface AccountEntityMapper extends EntityMapper<AccountEntityDTO, AccountEntity> {


    @Mapping(target = "transactionEntities", ignore = true)
    @Mapping(target = "removeTransactionEntity", ignore = true)
    AccountEntity toEntity(AccountEntityDTO accountEntityDTO);

    default AccountEntity fromId(Long id) {
        if (id == null) {
            return null;
        }
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setId(id);
        return accountEntity;
    }
}
