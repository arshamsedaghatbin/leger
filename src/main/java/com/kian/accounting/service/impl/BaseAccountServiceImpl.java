package com.kian.accounting.service.impl;

import com.kian.accounting.domain.BaseAccount;
import com.kian.accounting.service.dto.BaseAccountDTO;
import com.kian.accounting.service.BaseAccountService;
import com.kian.accounting.repository.BaseAccountRepository;
import com.kian.accounting.service.mapper.BaseAccountMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing BaseAccount.
 */
@Service
@Transactional
public class BaseAccountServiceImpl implements BaseAccountService {

    private final Logger log = LoggerFactory.getLogger(BaseAccountServiceImpl.class);

    private final BaseAccountRepository baseAccountRepository;

    private final BaseAccountMapper baseAccountMapper;

    public BaseAccountServiceImpl(BaseAccountRepository baseAccountRepository, BaseAccountMapper baseAccountMapper) {
        this.baseAccountRepository = baseAccountRepository;
        this.baseAccountMapper = baseAccountMapper;
    }

    /**
     * Save a baseAccount.
     *
     * @param baseAccountDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public BaseAccountDTO save(BaseAccountDTO baseAccountDTO) {
        log.debug("Request to save BaseAccount : {}", baseAccountDTO);
        BaseAccount baseAccount = baseAccountMapper.toEntity(baseAccountDTO);
        baseAccount = baseAccountRepository.save(baseAccount);
        return baseAccountMapper.toDto(baseAccount);
    }

    /**
     * Get all the baseAccounts.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<BaseAccountDTO> findAll(Pageable pageable) {
        log.debug("Request to get all BaseAccounts");
        return baseAccountRepository.findAll(pageable)
            .map(baseAccountMapper::toDto);
    }


    /**
     * Get one baseAccount by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<BaseAccountDTO> findOne(Long id) {
        log.debug("Request to get BaseAccount : {}", id);
        return Optional.of(baseAccountRepository.findOne(id))
            .map(baseAccountMapper::toDto);
    }

    /**
     * Delete the baseAccount by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete BaseAccount : {}", id);
        baseAccountRepository.delete(id);
    }
}
