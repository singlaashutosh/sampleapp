package com.mycompany.myapp.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class TransactionEntityMapperTest {

    private TransactionEntityMapper transactionEntityMapper;

    @BeforeEach
    public void setUp() {
        transactionEntityMapper = new TransactionEntityMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(transactionEntityMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(transactionEntityMapper.fromId(null)).isNull();
    }
}
