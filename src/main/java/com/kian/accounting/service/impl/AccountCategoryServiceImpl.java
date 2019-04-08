package com.kian.accounting.service.impl;

import com.kian.accounting.domain.AccountCategory;
import com.kian.accounting.service.dto.AccountCategoryDTO;
import com.kian.accounting.service.AccountCategoryService;
import com.kian.accounting.repository.AccountCategoryRepository;
import com.kian.accounting.service.mapper.AccountCategoryMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing AccountCategory.
 */
@Service
@Transactional
public class AccountCategoryServiceImpl implements AccountCategoryService {

    private final Logger log = LoggerFactory.getLogger(AccountCategoryServiceImpl.class);

    private final AccountCategoryRepository accountCategoryRepository;

    private final AccountCategoryMapper accountCategoryMapper;

    public AccountCategoryServiceImpl(AccountCategoryRepository accountCategoryRepository, AccountCategoryMapper accountCategoryMapper) {
        this.accountCategoryRepository = accountCategoryRepository;
        this.accountCategoryMapper = accountCategoryMapper;
    }

    /**
     * Save a accountCategory.
     *
     * @param accountCategoryDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public AccountCategoryDTO save(AccountCategoryDTO accountCategoryDTO) {
        log.debug("Request to save AccountCategory : {}", accountCategoryDTO);
        AccountCategory accountCategory = accountCategoryMapper.toEntity(accountCategoryDTO);
        accountCategory = accountCategoryRepository.save(accountCategory);
        return accountCategoryMapper.toDto(accountCategory);
    }

    /**
     * Get all the accountCategories.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<AccountCategoryDTO> findAll() {
        log.debug("Request to get all AccountCategories");
        return accountCategoryRepository.findAll().stream()
            .map(accountCategoryMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one accountCategory by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<AccountCategoryDTO> findOne(Long id) {
        log.debug("Request to get AccountCategory : {}", id);
        return Optional.of(accountCategoryRepository.findOne(id))
            .map(accountCategoryMapper::toDto);
    }

    /**
     * Delete the accountCategory by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete AccountCategory : {}", id);
        accountCategoryRepository.delete(id);
    }
}
