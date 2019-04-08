package com.kian.accounting.service;

import com.kian.accounting.service.dto.AccountDetailsDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing AccountDetails.
 */
public interface AccountDetailsService {

    /**
     * Save a accountDetails.
     *
     * @param accountDetailsDTO the entity to save
     * @return the persisted entity
     */
    AccountDetailsDTO save(AccountDetailsDTO accountDetailsDTO);

    /**
     * Get all the accountDetails.
     *
     * @return the list of entities
     */
    List<AccountDetailsDTO> findAll();


    /**
     * Get the "id" accountDetails.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<AccountDetailsDTO> findOne(Long id);

    /**
     * Delete the "id" accountDetails.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
