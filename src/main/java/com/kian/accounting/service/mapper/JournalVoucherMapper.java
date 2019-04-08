package com.kian.accounting.service.mapper;

import com.kian.accounting.domain.JournalVoucher;
import com.kian.accounting.service.dto.JournalVoucherDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity JournalVoucher and its DTO JournalVoucherDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface JournalVoucherMapper extends EntityMapper<JournalVoucherDTO, JournalVoucher> {


    @Mapping(target = "articles", ignore = true)
    JournalVoucher toEntity(JournalVoucherDTO journalVoucherDTO);

    default JournalVoucher fromId(Long id) {
        if (id == null) {
            return null;
        }
        JournalVoucher journalVoucher = new JournalVoucher();
        journalVoucher.setId(id);
        return journalVoucher;
    }
}
