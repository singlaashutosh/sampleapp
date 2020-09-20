package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.AccountEntity;
import com.mycompany.myapp.repository.AccountEntityRepository;
import com.mycompany.myapp.service.dto.AccountEntityDTO;
import com.mycompany.myapp.service.mapper.AccountEntityMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link AccountEntity}.
 */
@Service
@Transactional
public class AccountEntityService {

    private final Logger log = LoggerFactory.getLogger(AccountEntityService.class);

    private final AccountEntityRepository accountEntityRepository;

    private final AccountEntityMapper accountEntityMapper;

    public AccountEntityService(AccountEntityRepository accountEntityRepository, AccountEntityMapper accountEntityMapper) {
        this.accountEntityRepository = accountEntityRepository;
        this.accountEntityMapper = accountEntityMapper;
    }

    /**
     * Save a accountEntity.
     *
     * @param accountEntityDTO the entity to save.
     * @return the persisted entity.
     */
    public AccountEntityDTO save(AccountEntityDTO accountEntityDTO) {
        log.debug("Request to save AccountEntity : {}", accountEntityDTO);
        AccountEntity accountEntity = accountEntityMapper.toEntity(accountEntityDTO);
        accountEntity = accountEntityRepository.save(accountEntity);
        return accountEntityMapper.toDto(accountEntity);
    }

    /**
     * Get all the accountEntities.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<AccountEntityDTO> findAll(Pageable pageable) {
        log.debug("Request to get all AccountEntities");
        return accountEntityRepository.findAll(pageable)
            .map(accountEntityMapper::toDto);
    }


    /**
     * Get one accountEntity by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<AccountEntityDTO> findOne(Long id) {
        log.debug("Request to get AccountEntity : {}", id);
        return accountEntityRepository.findById(id)
            .map(accountEntityMapper::toDto);
    }

    /**
     * Delete the accountEntity by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete AccountEntity : {}", id);
        accountEntityRepository.deleteById(id);
    }
}
