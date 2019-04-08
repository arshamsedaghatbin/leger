package com.kian.accounting.web.rest;
import com.kian.accounting.web.rest.errors.BadRequestAlertException;
import com.kian.accounting.web.rest.util.HeaderUtil;
import com.kian.accounting.service.AccountGroupService;
import com.kian.accounting.service.dto.AccountGroupDTO;
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
 * REST controller for managing AccountGroup.
 */
@RestController
@RequestMapping("/api")
public class AccountGroupResource {

    private final Logger log = LoggerFactory.getLogger(AccountGroupResource.class);

    private static final String ENTITY_NAME = "AccountGroup";

    private final AccountGroupService accountGroupService;

    public AccountGroupResource(AccountGroupService accountGroupService) {
        this.accountGroupService = accountGroupService;
    }

    /**
     * POST  /account-groups : Create a new accountGroup.
     *
     * @param accountGroupDTO the accountGroupDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new accountGroupDTO, or with status 400 (Bad Request) if the accountGroup has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/account-groups")
    public ResponseEntity<AccountGroupDTO> createAccountGroup(
        @RequestHeader(HttpHeaders.AUTHORIZATION) final String authorization,
        @Valid @RequestBody AccountGroupDTO accountGroupDTO) throws URISyntaxException {
        log.debug("REST request to save AccountGroup : {}", accountGroupDTO);
        if (accountGroupDTO.getId() != null) {
            throw new BadRequestAlertException("A new accountGroup cannot already have an ID", ENTITY_NAME, "idexists");
        }
        AccountGroupDTO result = accountGroupService.save(accountGroupDTO);
        return ResponseEntity.created(new URI("/api/account-groups/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /account-groups : Updates an existing accountGroup.
     *
     * @param accountGroupDTO the accountGroupDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated accountGroupDTO,
     * or with status 400 (Bad Request) if the accountGroupDTO is not valid,
     * or with status 500 (Internal Server Error) if the accountGroupDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/account-groups")
    public ResponseEntity<AccountGroupDTO> updateAccountGroup(@Valid @RequestBody AccountGroupDTO accountGroupDTO) throws URISyntaxException {
        log.debug("REST request to update AccountGroup : {}", accountGroupDTO);
        if (accountGroupDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        AccountGroupDTO result = accountGroupService.save(accountGroupDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, accountGroupDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /account-groups : get all the accountGroups.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of accountGroups in body
     */
    @GetMapping("/account-groups")
    public List<AccountGroupDTO> getAllAccountGroups() {
        log.debug("REST request to get all AccountGroups");
        return accountGroupService.findAll();
    }

    /**
     * GET  /account-groups/:id : get the "id" accountGroup.
     *
     * @param id the id of the accountGroupDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the accountGroupDTO, or with status 404 (Not Found)
     */
    @GetMapping("/account-groups/{id}")
    public ResponseEntity<AccountGroupDTO> getAccountGroup(@PathVariable Long id) {
        log.debug("REST request to get AccountGroup : {}", id);
        Optional<AccountGroupDTO> accountGroupDTO = accountGroupService.findOne(id);
        return ResponseUtil.wrapOrNotFound(accountGroupDTO);
    }

    /**
     * DELETE  /account-groups/:id : delete the "id" accountGroup.
     *
     * @param id the id of the accountGroupDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/account-groups/{id}")
    public ResponseEntity<Void> deleteAccountGroup(@PathVariable Long id) {
        log.debug("REST request to delete AccountGroup : {}", id);
        accountGroupService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
