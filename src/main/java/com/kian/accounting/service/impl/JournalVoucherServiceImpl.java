package com.kian.accounting.service.impl;

import com.kian.accounting.domain.JournalVoucher;
import com.kian.accounting.service.dto.JournalVoucherDTO;
import com.kian.accounting.service.JournalVoucherService;
import com.kian.accounting.repository.JournalVoucherRepository;
import com.kian.accounting.service.mapper.JournalVoucherMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Optional;

/**
 * Service Implementation for managing JournalVoucher.
 */
@Service
@Transactional
public class JournalVoucherServiceImpl implements JournalVoucherService {

    private final Logger log = LoggerFactory.getLogger(JournalVoucherServiceImpl.class);

    private final JournalVoucherRepository journalVoucherRepository;

    private final JournalVoucherMapper journalVoucherMapper;

    public JournalVoucherServiceImpl(JournalVoucherRepository journalVoucherRepository, JournalVoucherMapper journalVoucherMapper) {
        this.journalVoucherRepository = journalVoucherRepository;
        this.journalVoucherMapper = journalVoucherMapper;
    }

    /**
     * Save a journalVoucher.
     *
     * @param journalVoucherDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public JournalVoucherDTO save(JournalVoucherDTO journalVoucherDTO) {
        log.debug("Request to save JournalVoucher : {}", journalVoucherDTO);
        JournalVoucher journalVoucher = journalVoucherMapper.toEntity(journalVoucherDTO);
        journalVoucher.setGenerationDate(Instant.now());
        journalVoucher = journalVoucherRepository.save(journalVoucher);
        return journalVoucherMapper.toDto(journalVoucher);
    }

    /**
     * Get all the journalVouchers.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<JournalVoucherDTO> findAll(Pageable pageable) {
        log.debug("Request to get all JournalVouchers");
        return journalVoucherRepository.findAll(pageable)
            .map(journalVoucherMapper::toDto);
    }


    /**
     * Get one journalVoucher by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<JournalVoucherDTO> findOne(Long id) {
        log.debug("Request to get JournalVoucher : {}", id);
        return Optional.of(journalVoucherRepository.findOne(id))
            .map(journalVoucherMapper::toDto);
    }

    /**
     * Delete the journalVoucher by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete JournalVoucher : {}", id);
        journalVoucherRepository.delete(id);
    }
}
