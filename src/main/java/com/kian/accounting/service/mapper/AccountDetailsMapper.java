package com.kian.accounting.service.mapper;

import com.kian.accounting.domain.AccountDetails;
import com.kian.accounting.service.dto.AccountDetailsDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity AccountDetails and its DTO AccountDetailsDTO.
 */
@Mapper(componentModel = "spring", uses = {BaseAccountMapper.class})
public interface AccountDetailsMapper extends EntityMapper<AccountDetailsDTO, AccountDetails> {

    @Mapping(source = "baseAccount.id", target = "baseAccountId")
    AccountDetailsDTO toDto(AccountDetails accountDetails);

    @Mapping(source = "baseAccountId", target = "baseAccount")
    AccountDetails toEntity(AccountDetailsDTO accountDetailsDTO);

    default AccountDetails fromId(Long id) {
        if (id == null) {
            return null;
        }
        AccountDetails accountDetails = new AccountDetails();
        accountDetails.setId(id);
        return accountDetails;
    }
}
