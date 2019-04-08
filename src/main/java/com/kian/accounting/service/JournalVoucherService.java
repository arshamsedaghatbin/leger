package com.kian.accounting.service;

import com.kian.accounting.service.dto.JournalVoucherDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing JournalVoucher.
 */
public interface JournalVoucherService {

    /**
     * Save a journalVoucher.
     *
     * @param journalVoucherDTO the entity to save
     * @return the persisted entity
     */
    JournalVoucherDTO save(JournalVoucherDTO journalVoucherDTO);

    /**
     * Get all the journalVouchers.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<JournalVoucherDTO> findAll(Pageable pageable);


    /**
     * Get the "id" journalVoucher.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<JournalVoucherDTO> findOne(Long id);

    /**
     * Delete the "id" journalVoucher.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
