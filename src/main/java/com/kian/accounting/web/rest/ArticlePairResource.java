package com.kian.accounting.web.rest;
import com.kian.accounting.web.rest.errors.BadRequestAlertException;
import com.kian.accounting.web.rest.util.HeaderUtil;
import com.kian.accounting.service.ArticlePairService;
import com.kian.accounting.service.dto.ArticlePairDTO;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing ArticlePair.
 */
@RestController
@RequestMapping("/api")
public class ArticlePairResource {

    private final Logger log = LoggerFactory.getLogger(ArticlePairResource.class);

    private static final String ENTITY_NAME = "ArticlePair";

    private final ArticlePairService articlePairService;

    public ArticlePairResource(ArticlePairService articlePairService) {
        this.articlePairService = articlePairService;
    }

    /**
     * POST  /article-pairs : Create a new articlePair.
     *
     * @param articlePairDTO the articlePairDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new articlePairDTO, or with status 400 (Bad Request) if the articlePair has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/article-pairs")
    public ResponseEntity<ArticlePairDTO> createArticlePair(@RequestBody ArticlePairDTO articlePairDTO) throws URISyntaxException {
        log.debug("REST request to save ArticlePair : {}", articlePairDTO);
        if (articlePairDTO.getId() != null) {
            throw new BadRequestAlertException("A new articlePair cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ArticlePairDTO result = articlePairService.save(articlePairDTO);
        return ResponseEntity.created(new URI("/api/article-pairs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /article-pairs : Updates an existing articlePair.
     *
     * @param articlePairDTO the articlePairDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated articlePairDTO,
     * or with status 400 (Bad Request) if the articlePairDTO is not valid,
     * or with status 500 (Internal Server Error) if the articlePairDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/article-pairs")
    public ResponseEntity<ArticlePairDTO> updateArticlePair(@RequestBody ArticlePairDTO articlePairDTO) throws URISyntaxException {
        log.debug("REST request to update ArticlePair : {}", articlePairDTO);
        if (articlePairDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        ArticlePairDTO result = articlePairService.save(articlePairDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, articlePairDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /article-pairs : get all the articlePairs.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of articlePairs in body
     */
    @GetMapping("/article-pairs")
    public List<ArticlePairDTO> getAllArticlePairs() {
        log.debug("REST request to get all ArticlePairs");
        return articlePairService.findAll();
    }

    /**
     * GET  /article-pairs/:id : get the "id" articlePair.
     *
     * @param id the id of the articlePairDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the articlePairDTO, or with status 404 (Not Found)
     */
    @GetMapping("/article-pairs/{id}")
    public ResponseEntity<ArticlePairDTO> getArticlePair(@PathVariable Long id) {
        log.debug("REST request to get ArticlePair : {}", id);
        Optional<ArticlePairDTO> articlePairDTO = articlePairService.findOne(id);
        return ResponseUtil.wrapOrNotFound(articlePairDTO);
    }

    /**
     * DELETE  /article-pairs/:id : delete the "id" articlePair.
     *
     * @param id the id of the articlePairDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/article-pairs/{id}")
    public ResponseEntity<Void> deleteArticlePair(@PathVariable Long id) {
        log.debug("REST request to delete ArticlePair : {}", id);
        articlePairService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
