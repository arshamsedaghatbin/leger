package com.kian.accounting.service;

import com.kian.accounting.service.dto.AccountCategoryDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing AccountCategory.
 */
public interface AccountCategoryService {

    /**
     * Save a accountCategory.
     *
     * @param accountCategoryDTO the entity to save
     * @return the persisted entity
     */
    AccountCategoryDTO save(AccountCategoryDTO accountCategoryDTO);

    /**
     * Get all the accountCategories.
     *
     * @return the list of entities
     */
    List<AccountCategoryDTO> findAll();


    /**
     * Get the "id" accountCategory.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<AccountCategoryDTO> findOne(Long id);

    /**
     * Delete the "id" accountCategory.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
