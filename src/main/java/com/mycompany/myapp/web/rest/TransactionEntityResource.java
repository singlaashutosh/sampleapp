package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.service.TransactionEntityService;
import com.mycompany.myapp.web.rest.errors.BadRequestAlertException;
import com.mycompany.myapp.service.dto.TransactionEntityDTO;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.mycompany.myapp.domain.TransactionEntity}.
 */
@RestController
@RequestMapping("/api")
public class TransactionEntityResource {

    private final Logger log = LoggerFactory.getLogger(TransactionEntityResource.class);

    private static final String ENTITY_NAME = "transactionEntity";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final TransactionEntityService transactionEntityService;

    public TransactionEntityResource(TransactionEntityService transactionEntityService) {
        this.transactionEntityService = transactionEntityService;
    }

    /**
     * {@code POST  /transaction-entities} : Create a new transactionEntity.
     *
     * @param transactionEntityDTO the transactionEntityDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new transactionEntityDTO, or with status {@code 400 (Bad Request)} if the transactionEntity has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/transaction-entities")
    public ResponseEntity<TransactionEntityDTO> createTransactionEntity(@Valid @RequestBody TransactionEntityDTO transactionEntityDTO) throws URISyntaxException {
        log.debug("REST request to save TransactionEntity : {}", transactionEntityDTO);
        if (transactionEntityDTO.getId() != null) {
            throw new BadRequestAlertException("A new transactionEntity cannot already have an ID", ENTITY_NAME, "idexists");
        }
        TransactionEntityDTO result = transactionEntityService.save(transactionEntityDTO);
        return ResponseEntity.created(new URI("/api/transaction-entities/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /transaction-entities} : Updates an existing transactionEntity.
     *
     * @param transactionEntityDTO the transactionEntityDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated transactionEntityDTO,
     * or with status {@code 400 (Bad Request)} if the transactionEntityDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the transactionEntityDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/transaction-entities")
    public ResponseEntity<TransactionEntityDTO> updateTransactionEntity(@Valid @RequestBody TransactionEntityDTO transactionEntityDTO) throws URISyntaxException {
        log.debug("REST request to update TransactionEntity : {}", transactionEntityDTO);
        if (transactionEntityDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        TransactionEntityDTO result = transactionEntityService.save(transactionEntityDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, transactionEntityDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /transaction-entities} : get all the transactionEntities.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of transactionEntities in body.
     */
    @GetMapping("/transaction-entities")
    public ResponseEntity<List<TransactionEntityDTO>> getAllTransactionEntities(Pageable pageable) {
        log.debug("REST request to get a page of TransactionEntities");
        Page<TransactionEntityDTO> page = transactionEntityService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /transaction-entities/:id} : get the "id" transactionEntity.
     *
     * @param id the id of the transactionEntityDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the transactionEntityDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/transaction-entities/{id}")
    public ResponseEntity<TransactionEntityDTO> getTransactionEntity(@PathVariable Long id) {
        log.debug("REST request to get TransactionEntity : {}", id);
        Optional<TransactionEntityDTO> transactionEntityDTO = transactionEntityService.findOne(id);
        return ResponseUtil.wrapOrNotFound(transactionEntityDTO);
    }

    /**
     * {@code DELETE  /transaction-entities/:id} : delete the "id" transactionEntity.
     *
     * @param id the id of the transactionEntityDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/transaction-entities/{id}")
    public ResponseEntity<Void> deleteTransactionEntity(@PathVariable Long id) {
        log.debug("REST request to delete TransactionEntity : {}", id);
        transactionEntityService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
