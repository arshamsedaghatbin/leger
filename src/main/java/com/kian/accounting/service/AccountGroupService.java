package com.kian.accounting.service;

import com.kian.accounting.service.dto.AccountGroupDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing AccountGroup.
 */
public interface AccountGroupService {

    /**
     * Save a accountGroup.
     *
     * @param accountGroupDTO the entity to save
     * @return the persisted entity
     */
    AccountGroupDTO save(AccountGroupDTO accountGroupDTO);

    /**
     * Get all the accountGroups.
     *
     * @return the list of entities
     */
    List<AccountGroupDTO> findAll();


    /**
     * Get the "id" accountGroup.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<AccountGroupDTO> findOne(Long id);

    /**
     * Delete the "id" accountGroup.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
