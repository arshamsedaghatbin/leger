package com.kian.accounting.web.rest;
import com.kian.accounting.web.rest.errors.BadRequestAlertException;
import com.kian.accounting.web.rest.util.HeaderUtil;
import com.kian.accounting.service.AccountCategoryService;
import com.kian.accounting.service.dto.AccountCategoryDTO;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing AccountCategory.
 */
@RestController
@RequestMapping("/api")
public class AccountCategoryResource {

    private final Logger log = LoggerFactory.getLogger(AccountCategoryResource.class);

    private static final String ENTITY_NAME = "AccountCategory";

    private final AccountCategoryService accountCategoryService;

    public AccountCategoryResource(AccountCategoryService accountCategoryService) {
        this.accountCategoryService = accountCategoryService;
    }

    /**
     * POST  /account-categories : Create a new accountCategory.
     *
     * @param accountCategoryDTO the accountCategoryDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new accountCategoryDTO, or with status 400 (Bad Request) if the accountCategory has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/account-categories")
    public ResponseEntity<AccountCategoryDTO> createAccountCategory(
        @RequestHeader(HttpHeaders.AUTHORIZATION) final String authorization,
        @Valid @RequestBody AccountCategoryDTO accountCategoryDTO) throws URISyntaxException {
        log.debug("REST request to save AccountCategory : {}", accountCategoryDTO);
        if (accountCategoryDTO.getId() != null) {
            throw new BadRequestAlertException("A new accountCategory cannot already have an ID", ENTITY_NAME, "idexists");
        }
        AccountCategoryDTO result = accountCategoryService.save(accountCategoryDTO);
        return ResponseEntity.created(new URI("/api/account-categories/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /account-categories : Updates an existing accountCategory.
     *
     * @param accountCategoryDTO the accountCategoryDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated accountCategoryDTO,
     * or with status 400 (Bad Request) if the accountCategoryDTO is not valid,
     * or with status 500 (Internal Server Error) if the accountCategoryDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/account-categories")
    public ResponseEntity<AccountCategoryDTO> updateAccountCategory(@Valid @RequestBody AccountCategoryDTO accountCategoryDTO) throws URISyntaxException {
        log.debug("REST request to update AccountCategory : {}", accountCategoryDTO);
        if (accountCategoryDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        AccountCategoryDTO result = accountCategoryService.save(accountCategoryDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, accountCategoryDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /account-categories : get all the accountCategories.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of accountCategories in body
     */
    @GetMapping("/account-categories")
    public List<AccountCategoryDTO> getAllAccountCategories() {
        log.debug("REST request to get all AccountCategories");
        return accountCategoryService.findAll();
    }

    /**
     * GET  /account-categories/:id : get the "id" accountCategory.
     *
     * @param id the id of the accountCategoryDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the accountCategoryDTO, or with status 404 (Not Found)
     */
    @GetMapping("/account-categories/{id}")
    public ResponseEntity<AccountCategoryDTO> getAccountCategory(@PathVariable Long id) {
        log.debug("REST request to get AccountCategory : {}", id);
        Optional<AccountCategoryDTO> accountCategoryDTO = accountCategoryService.findOne(id);
        return ResponseUtil.wrapOrNotFound(accountCategoryDTO);
    }

    /**
     * DELETE  /account-categories/:id : delete the "id" accountCategory.
     *
     * @param id the id of the accountCategoryDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/account-categories/{id}")
    public ResponseEntity<Void> deleteAccountCategory(@PathVariable Long id) {
        log.debug("REST request to delete AccountCategory : {}", id);
        accountCategoryService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
