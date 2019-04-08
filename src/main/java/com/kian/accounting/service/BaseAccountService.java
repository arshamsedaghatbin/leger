package com.kian.accounting.service;

import com.kian.accounting.service.dto.BaseAccountDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing BaseAccount.
 */
public interface BaseAccountService {

    /**
     * Save a baseAccount.
     *
     * @param baseAccountDTO the entity to save
     * @return the persisted entity
     */
    BaseAccountDTO save(BaseAccountDTO baseAccountDTO);

    /**
     * Get all the baseAccounts.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<BaseAccountDTO> findAll(Pageable pageable);


    /**
     * Get the "id" baseAccount.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<BaseAccountDTO> findOne(Long id);

    /**
     * Delete the "id" baseAccount.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
