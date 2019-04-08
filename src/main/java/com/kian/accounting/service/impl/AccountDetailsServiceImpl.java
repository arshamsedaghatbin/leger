package com.kian.accounting.service.impl;

import com.kian.accounting.domain.AccountDetails;
import com.kian.accounting.service.dto.AccountDetailsDTO;
import com.kian.accounting.service.AccountDetailsService;
import com.kian.accounting.repository.AccountDetailsRepository;
import com.kian.accounting.service.mapper.AccountDetailsMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing AccountDetails.
 */
@Service
@Transactional
public class AccountDetailsServiceImpl implements AccountDetailsService {

    private final Logger log = LoggerFactory.getLogger(AccountDetailsServiceImpl.class);

    private final AccountDetailsRepository accountDetailsRepository;

    private final AccountDetailsMapper accountDetailsMapper;

    public AccountDetailsServiceImpl(AccountDetailsRepository accountDetailsRepository, AccountDetailsMapper accountDetailsMapper) {
        this.accountDetailsRepository = accountDetailsRepository;
        this.accountDetailsMapper = accountDetailsMapper;
    }

    /**
     * Save a accountDetails.
     *
     * @param accountDetailsDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public AccountDetailsDTO save(AccountDetailsDTO accountDetailsDTO) {
        log.debug("Request to save AccountDetails : {}", accountDetailsDTO);
        AccountDetails accountDetails = accountDetailsMapper.toEntity(accountDetailsDTO);
        accountDetails = accountDetailsRepository.save(accountDetails);
        return accountDetailsMapper.toDto(accountDetails);
    }

    /**
     * Get all the accountDetails.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<AccountDetailsDTO> findAll() {
        log.debug("Request to get all AccountDetails");
        return accountDetailsRepository.findAll().stream()
            .map(accountDetailsMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one accountDetails by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<AccountDetailsDTO> findOne(Long id) {
        log.debug("Request to get AccountDetails : {}", id);
        return Optional.of(accountDetailsRepository.findOne(id))
            .map(accountDetailsMapper::toDto);
    }

    /**
     * Delete the accountDetails by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete AccountDetails : {}", id);
        accountDetailsRepository.delete(id);
    }
}
