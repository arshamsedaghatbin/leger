package com.kian.accounting.service.mapper;

import com.kian.accounting.domain.AccountGroup;
import com.kian.accounting.service.dto.AccountGroupDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity AccountGroup and its DTO AccountGroupDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface AccountGroupMapper extends EntityMapper<AccountGroupDTO, AccountGroup> {


    @Mapping(target = "accountCategories", ignore = true)
    AccountGroup toEntity(AccountGroupDTO accountGroupDTO);

    default AccountGroup fromId(Long id) {
        if (id == null) {
            return null;
        }
        AccountGroup accountGroup = new AccountGroup();
        accountGroup.setId(id);
        return accountGroup;
    }
}
