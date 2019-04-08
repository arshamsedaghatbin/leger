package com.kian.accounting.service.impl;

import com.kian.accounting.domain.ArticlePair;
import com.kian.accounting.service.dto.ArticlePairDTO;
import com.kian.accounting.service.ArticlePairService;
import com.kian.accounting.repository.ArticlePairRepository;
import com.kian.accounting.service.mapper.ArticlePairMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing ArticlePair.
 */
@Service
@Transactional
public class ArticlePairServiceImpl implements ArticlePairService {

    private final Logger log = LoggerFactory.getLogger(ArticlePairServiceImpl.class);

    private final ArticlePairRepository articlePairRepository;

    private final ArticlePairMapper articlePairMapper;

    public ArticlePairServiceImpl(ArticlePairRepository articlePairRepository, ArticlePairMapper articlePairMapper) {
        this.articlePairRepository = articlePairRepository;
        this.articlePairMapper = articlePairMapper;
    }

    /**
     * Save a articlePair.
     *
     * @param articlePairDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public ArticlePairDTO save(ArticlePairDTO articlePairDTO) {
        log.debug("Request to save ArticlePair : {}", articlePairDTO);
        ArticlePair articlePair = articlePairMapper.toEntity(articlePairDTO);
        articlePair = articlePairRepository.save(articlePair);
        return articlePairMapper.toDto(articlePair);
    }

    /**
     * Get all the articlePairs.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<ArticlePairDTO> findAll() {
        log.debug("Request to get all ArticlePairs");
        return articlePairRepository.findAll().stream()
            .map(articlePairMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one articlePair by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<ArticlePairDTO> findOne(Long id) {
        log.debug("Request to get ArticlePair : {}", id);
        return Optional.of(articlePairRepository.findOne(id))
            .map(articlePairMapper::toDto);
    }

    /**
     * Delete the articlePair by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete ArticlePair : {}", id);
        articlePairRepository.delete(id);
    }
}
