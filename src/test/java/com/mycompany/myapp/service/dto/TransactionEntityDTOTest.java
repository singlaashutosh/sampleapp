package com.mycompany.myapp.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.mycompany.myapp.web.rest.TestUtil;

public class TransactionEntityDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(TransactionEntityDTO.class);
        TransactionEntityDTO transactionEntityDTO1 = new TransactionEntityDTO();
        transactionEntityDTO1.setId(1L);
        TransactionEntityDTO transactionEntityDTO2 = new TransactionEntityDTO();
        assertThat(transactionEntityDTO1).isNotEqualTo(transactionEntityDTO2);
        transactionEntityDTO2.setId(transactionEntityDTO1.getId());
        assertThat(transactionEntityDTO1).isEqualTo(transactionEntityDTO2);
        transactionEntityDTO2.setId(2L);
        assertThat(transactionEntityDTO1).isNotEqualTo(transactionEntityDTO2);
        transactionEntityDTO1.setId(null);
        assertThat(transactionEntityDTO1).isNotEqualTo(transactionEntityDTO2);
    }
}
