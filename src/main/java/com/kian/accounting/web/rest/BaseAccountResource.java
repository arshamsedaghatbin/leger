package com.kian.accounting.web.rest;
import com.kian.accounting.web.rest.util.HeaderUtil;
import com.kian.accounting.web.rest.util.PaginationUtil;
import com.kian.accounting.service.BaseAccountService;
import com.kian.accounting.web.rest.errors.BadRequestAlertException;
import com.kian.accounting.service.dto.BaseAccountDTO;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing BaseAccount.
 */
@RestController
@RequestMapping("/api")
public class BaseAccountResource {

    private final Logger log = LoggerFactory.getLogger(BaseAccountResource.class);

    private static final String ENTITY_NAME = "BaseAccount";

    private final BaseAccountService baseAccountService;

    public BaseAccountResource(BaseAccountService baseAccountService) {
        this.baseAccountService = baseAccountService;
    }

    /**
     * POST  /base-accounts : Create a new baseAccount.
     *
     * @param baseAccountDTO the baseAccountDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new baseAccountDTO, or with status 400 (Bad Request) if the baseAccount has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/base-accounts")
    public ResponseEntity<BaseAccountDTO> createBaseAccount(@Valid @RequestBody BaseAccountDTO baseAccountDTO) throws URISyntaxException {
        log.debug("REST request to save BaseAccount : {}", baseAccountDTO);
        if (baseAccountDTO.getId() != null) {
            throw new BadRequestAlertException("A new baseAccount cannot already have an ID", ENTITY_NAME, "idexists");
        }
        BaseAccountDTO result = baseAccountService.save(baseAccountDTO);
        return ResponseEntity.created(new URI("/api/base-accounts/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /base-accounts : Updates an existing baseAccount.
     *
     * @param baseAccountDTO the baseAccountDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated baseAccountDTO,
     * or with status 400 (Bad Request) if the baseAccountDTO is not valid,
     * or with status 500 (Internal Server Error) if the baseAccountDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/base-accounts")
    public ResponseEntity<BaseAccountDTO> updateBaseAccount(@Valid @RequestBody BaseAccountDTO baseAccountDTO) throws URISyntaxException {
        log.debug("REST request to update BaseAccount : {}", baseAccountDTO);
        if (baseAccountDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        BaseAccountDTO result = baseAccountService.save(baseAccountDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, baseAccountDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /base-accounts : get all the baseAccounts.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of baseAccounts in body
     */
    @GetMapping("/base-accounts")
    public ResponseEntity<List<BaseAccountDTO>> getAllBaseAccounts(Pageable pageable) {
        log.debug("REST request to get a page of BaseAccounts");
        Page<BaseAccountDTO> page = baseAccountService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/base-accounts");
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * GET  /base-accounts/:id : get the "id" baseAccount.
     *
     * @param id the id of the baseAccountDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the baseAccountDTO, or with status 404 (Not Found)
     */
    @GetMapping("/base-accounts/{id}")
    public ResponseEntity<BaseAccountDTO> getBaseAccount(@PathVariable Long id) {
        log.debug("REST request to get BaseAccount : {}", id);
        Optional<BaseAccountDTO> baseAccountDTO = baseAccountService.findOne(id);
        return ResponseUtil.wrapOrNotFound(baseAccountDTO);
    }

    /**
     * DELETE  /base-accounts/:id : delete the "id" baseAccount.
     *
     * @param id the id of the baseAccountDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/base-accounts/{id}")
    public ResponseEntity<Void> deleteBaseAccount(@PathVariable Long id) {
        log.debug("REST request to delete BaseAccount : {}", id);
        baseAccountService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
