package com.kian.accounting.service;

import com.kian.accounting.service.dto.ArticlePairDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing ArticlePair.
 */
public interface ArticlePairService {

    /**
     * Save a articlePair.
     *
     * @param articlePairDTO the entity to save
     * @return the persisted entity
     */
    ArticlePairDTO save(ArticlePairDTO articlePairDTO);

    /**
     * Get all the articlePairs.
     *
     * @return the list of entities
     */
    List<ArticlePairDTO> findAll();


    /**
     * Get the "id" articlePair.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<ArticlePairDTO> findOne(Long id);

    /**
     * Delete the "id" articlePair.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
