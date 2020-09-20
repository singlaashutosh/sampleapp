package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.service.AccountEntityService;
import com.mycompany.myapp.web.rest.errors.BadRequestAlertException;
import com.mycompany.myapp.service.dto.AccountEntityDTO;

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
 * REST controller for managing {@link com.mycompany.myapp.domain.AccountEntity}.
 */
@RestController
@RequestMapping("/api")
public class AccountEntityResource {

    private final Logger log = LoggerFactory.getLogger(AccountEntityResource.class);

    private static final String ENTITY_NAME = "accountEntity";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final AccountEntityService accountEntityService;

    public AccountEntityResource(AccountEntityService accountEntityService) {
        this.accountEntityService = accountEntityService;
    }

    /**
     * {@code POST  /account-entities} : Create a new accountEntity.
     *
     * @param accountEntityDTO the accountEntityDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new accountEntityDTO, or with status {@code 400 (Bad Request)} if the accountEntity has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/account-entities")
    public ResponseEntity<AccountEntityDTO> createAccountEntity(@Valid @RequestBody AccountEntityDTO accountEntityDTO) throws URISyntaxException {
        log.debug("REST request to save AccountEntity : {}", accountEntityDTO);
        if (accountEntityDTO.getId() != null) {
            throw new BadRequestAlertException("A new accountEntity cannot already have an ID", ENTITY_NAME, "idexists");
        }
        AccountEntityDTO result = accountEntityService.save(accountEntityDTO);
        return ResponseEntity.created(new URI("/api/account-entities/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /account-entities} : Updates an existing accountEntity.
     *
     * @param accountEntityDTO the accountEntityDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated accountEntityDTO,
     * or with status {@code 400 (Bad Request)} if the accountEntityDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the accountEntityDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/account-entities")
    public ResponseEntity<AccountEntityDTO> updateAccountEntity(@Valid @RequestBody AccountEntityDTO accountEntityDTO) throws URISyntaxException {
        log.debug("REST request to update AccountEntity : {}", accountEntityDTO);
        if (accountEntityDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        AccountEntityDTO result = accountEntityService.save(accountEntityDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, accountEntityDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /account-entities} : get all the accountEntities.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of accountEntities in body.
     */
    @GetMapping("/account-entities")
    public ResponseEntity<List<AccountEntityDTO>> getAllAccountEntities(Pageable pageable) {
        log.debug("REST request to get a page of AccountEntities");
        Page<AccountEntityDTO> page = accountEntityService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /account-entities/:id} : get the "id" accountEntity.
     *
     * @param id the id of the accountEntityDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the accountEntityDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/account-entities/{id}")
    public ResponseEntity<AccountEntityDTO> getAccountEntity(@PathVariable Long id) {
        log.debug("REST request to get AccountEntity : {}", id);
        Optional<AccountEntityDTO> accountEntityDTO = accountEntityService.findOne(id);
        return ResponseUtil.wrapOrNotFound(accountEntityDTO);
    }

    /**
     * {@code DELETE  /account-entities/:id} : delete the "id" accountEntity.
     *
     * @param id the id of the accountEntityDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/account-entities/{id}")
    public ResponseEntity<Void> deleteAccountEntity(@PathVariable Long id) {
        log.debug("REST request to delete AccountEntity : {}", id);
        accountEntityService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
