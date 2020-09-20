package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.TransactionEntity;
import com.mycompany.myapp.repository.TransactionEntityRepository;
import com.mycompany.myapp.service.dto.TransactionEntityDTO;
import com.mycompany.myapp.service.mapper.TransactionEntityMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link TransactionEntity}.
 */
@Service
@Transactional
public class TransactionEntityService {

    private final Logger log = LoggerFactory.getLogger(TransactionEntityService.class);

    private final TransactionEntityRepository transactionEntityRepository;

    private final TransactionEntityMapper transactionEntityMapper;

    public TransactionEntityService(TransactionEntityRepository transactionEntityRepository, TransactionEntityMapper transactionEntityMapper) {
        this.transactionEntityRepository = transactionEntityRepository;
        this.transactionEntityMapper = transactionEntityMapper;
    }

    /**
     * Save a transactionEntity.
     *
     * @param transactionEntityDTO the entity to save.
     * @return the persisted entity.
     */
    public TransactionEntityDTO save(TransactionEntityDTO transactionEntityDTO) {
        log.debug("Request to save TransactionEntity : {}", transactionEntityDTO);
        TransactionEntity transactionEntity = transactionEntityMapper.toEntity(transactionEntityDTO);
        transactionEntity = transactionEntityRepository.save(transactionEntity);
        return transactionEntityMapper.toDto(transactionEntity);
    }

    /**
     * Get all the transactionEntities.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<TransactionEntityDTO> findAll(Pageable pageable) {
        log.debug("Request to get all TransactionEntities");
        return transactionEntityRepository.findAll(pageable)
            .map(transactionEntityMapper::toDto);
    }


    /**
     * Get one transactionEntity by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<TransactionEntityDTO> findOne(Long id) {
        log.debug("Request to get TransactionEntity : {}", id);
        return transactionEntityRepository.findById(id)
            .map(transactionEntityMapper::toDto);
    }

    /**
     * Delete the transactionEntity by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete TransactionEntity : {}", id);
        transactionEntityRepository.deleteById(id);
    }
}
