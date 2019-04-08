package com.kian.accounting.service.mapper;

import com.kian.accounting.domain.BaseAccount;
import com.kian.accounting.service.dto.BaseAccountDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity BaseAccount and its DTO BaseAccountDTO.
 */
@Mapper(componentModel = "spring", uses = {AccountCategoryMapper.class})
public interface BaseAccountMapper extends EntityMapper<BaseAccountDTO, BaseAccount> {

    @Mapping(source = "accountCategory.id", target = "accountCategoryId")
    BaseAccountDTO toDto(BaseAccount baseAccount);

    @Mapping(source = "accountCategoryId", target = "accountCategory")
    @Mapping(target = "accountDetails", ignore = true)
    BaseAccount toEntity(BaseAccountDTO baseAccountDTO);

    default BaseAccount fromId(Long id) {
        if (id == null) {
            return null;
        }
        BaseAccount baseAccount = new BaseAccount();
        baseAccount.setId(id);
        return baseAccount;
    }
}
