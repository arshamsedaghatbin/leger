package com.kian.accounting.service.mapper;

import com.kian.accounting.domain.AccountCategory;
import com.kian.accounting.service.dto.AccountCategoryDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity AccountCategory and its DTO AccountCategoryDTO.
 */
@Mapper(componentModel = "spring", uses = {AccountGroupMapper.class})
public interface AccountCategoryMapper extends EntityMapper<AccountCategoryDTO, AccountCategory> {

    @Mapping(source = "accountGroup.id", target = "accountGroupId")
    AccountCategoryDTO toDto(AccountCategory accountCategory);

    @Mapping(source = "accountGroupId", target = "accountGroup")
    @Mapping(target = "accounts", ignore = true)
    AccountCategory toEntity(AccountCategoryDTO accountCategoryDTO);

    default AccountCategory fromId(Long id) {
        if (id == null) {
            return null;
        }
        AccountCategory accountCategory = new AccountCategory();
        accountCategory.setId(id);
        return accountCategory;
    }
}
