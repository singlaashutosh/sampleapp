package com.mycompany.myapp.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class AccountEntityMapperTest {

    private AccountEntityMapper accountEntityMapper;

    @BeforeEach
    public void setUp() {
        accountEntityMapper = new AccountEntityMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(accountEntityMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(accountEntityMapper.fromId(null)).isNull();
    }
}
