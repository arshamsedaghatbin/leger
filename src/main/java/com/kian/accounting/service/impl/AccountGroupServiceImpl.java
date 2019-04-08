package com.kian.accounting.service.impl;

import com.kian.accounting.domain.AccountGroup;
import com.kian.accounting.service.dto.AccountGroupDTO;
import com.kian.accounting.service.AccountGroupService;
import com.kian.accounting.repository.AccountGroupRepository;
import com.kian.accounting.service.mapper.AccountGroupMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing AccountGroup.
 */
@Service
@Transactional
public class AccountGroupServiceImpl implements AccountGroupService {

    private final Logger log = LoggerFactory.getLogger(AccountGroupServiceImpl.class);

    private final AccountGroupRepository accountGroupRepository;

    private final AccountGroupMapper accountGroupMapper;

    public AccountGroupServiceImpl(AccountGroupRepository accountGroupRepository, AccountGroupMapper accountGroupMapper) {
        this.accountGroupRepository = accountGroupRepository;
        this.accountGroupMapper = accountGroupMapper;
    }

    /**
     * Save a accountGroup.
     *
     * @param accountGroupDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public AccountGroupDTO save(AccountGroupDTO accountGroupDTO) {
        log.debug("Request to save AccountGroup : {}", accountGroupDTO);
        AccountGroup accountGroup = accountGroupMapper.toEntity(accountGroupDTO);
        accountGroup = accountGroupRepository.save(accountGroup);
        return accountGroupMapper.toDto(accountGroup);
    }

    /**
     * Get all the accountGroups.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<AccountGroupDTO> findAll() {
        log.debug("Request to get all AccountGroups");
        return accountGroupRepository.findAll().stream()
            .map(accountGroupMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one accountGroup by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<AccountGroupDTO> findOne(Long id) {
        log.debug("Request to get AccountGroup : {}", id);
        return Optional.of(accountGroupRepository.findOne(id))
            .map(accountGroupMapper::toDto);
    }

    /**
     * Delete the accountGroup by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete AccountGroup : {}", id);
        accountGroupRepository.delete(id);
    }
}
