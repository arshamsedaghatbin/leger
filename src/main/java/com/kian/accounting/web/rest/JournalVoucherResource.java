package com.kian.accounting.web.rest;
import com.kian.accounting.web.rest.util.HeaderUtil;
import com.kian.accounting.web.rest.util.PaginationUtil;
import com.kian.accounting.service.JournalVoucherService;
import com.kian.accounting.web.rest.errors.BadRequestAlertException;
import com.kian.accounting.service.dto.JournalVoucherDTO;
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
 * REST controller for managing JournalVoucher.
 */
@RestController
@RequestMapping("/api")
public class JournalVoucherResource {

    private final Logger log = LoggerFactory.getLogger(JournalVoucherResource.class);

    private static final String ENTITY_NAME = "JournalVoucher";

    private final JournalVoucherService journalVoucherService;

    public JournalVoucherResource(JournalVoucherService journalVoucherService) {
        this.journalVoucherService = journalVoucherService;
    }

    /**
     * POST  /journal-vouchers : Create a new journalVoucher.
     *
     * @param journalVoucherDTO the journalVoucherDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new journalVoucherDTO, or with status 400 (Bad Request) if the journalVoucher has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/journal-vouchers")
    public ResponseEntity<JournalVoucherDTO> createJournalVoucher(@RequestHeader(HttpHeaders.AUTHORIZATION) final String authorization
        ,@Valid @RequestBody JournalVoucherDTO journalVoucherDTO) throws URISyntaxException {
        log.debug("REST request to save JournalVoucher : {}", journalVoucherDTO);
        if (journalVoucherDTO.getId() != null) {
            throw new BadRequestAlertException("A new journalVoucher cannot already have an ID", ENTITY_NAME, "idexists");
        }
        JournalVoucherDTO result = journalVoucherService.save(journalVoucherDTO);
        return ResponseEntity.created(new URI("/api/journal-vouchers/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /journal-vouchers : Updates an existing journalVoucher.
     *
     * @param journalVoucherDTO the journalVoucherDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated journalVoucherDTO,
     * or with status 400 (Bad Request) if the journalVoucherDTO is not valid,
     * or with status 500 (Internal Server Error) if the journalVoucherDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/journal-vouchers")
    public ResponseEntity<JournalVoucherDTO> updateJournalVoucher(@Valid @RequestBody JournalVoucherDTO journalVoucherDTO) throws URISyntaxException {
        log.debug("REST request to update JournalVoucher : {}", journalVoucherDTO);
        if (journalVoucherDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        JournalVoucherDTO result = journalVoucherService.save(journalVoucherDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, journalVoucherDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /journal-vouchers : get all the journalVouchers.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of journalVouchers in body
     */
    @GetMapping("/journal-vouchers")
    public ResponseEntity<List<JournalVoucherDTO>> getAllJournalVouchers(Pageable pageable) {
        log.debug("REST request to get a page of JournalVouchers");
        Page<JournalVoucherDTO> page = journalVoucherService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/journal-vouchers");
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * GET  /journal-vouchers/:id : get the "id" journalVoucher.
     *
     * @param id the id of the journalVoucherDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the journalVoucherDTO, or with status 404 (Not Found)
     */
    @GetMapping("/journal-vouchers/{id}")
    public ResponseEntity<JournalVoucherDTO> getJournalVoucher(@PathVariable Long id) {
        log.debug("REST request to get JournalVoucher : {}", id);
        Optional<JournalVoucherDTO> journalVoucherDTO = journalVoucherService.findOne(id);
        return ResponseUtil.wrapOrNotFound(journalVoucherDTO);
    }

    /**
     * DELETE  /journal-vouchers/:id : delete the "id" journalVoucher.
     *
     * @param id the id of the journalVoucherDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/journal-vouchers/{id}")
    public ResponseEntity<Void> deleteJournalVoucher(@PathVariable Long id) {
        log.debug("REST request to delete JournalVoucher : {}", id);
        journalVoucherService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
