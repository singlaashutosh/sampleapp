package com.mycompany.myapp.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.mycompany.myapp.web.rest.TestUtil;

public class AccountEntityDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(AccountEntityDTO.class);
        AccountEntityDTO accountEntityDTO1 = new AccountEntityDTO();
        accountEntityDTO1.setId(1L);
        AccountEntityDTO accountEntityDTO2 = new AccountEntityDTO();
        assertThat(accountEntityDTO1).isNotEqualTo(accountEntityDTO2);
        accountEntityDTO2.setId(accountEntityDTO1.getId());
        assertThat(accountEntityDTO1).isEqualTo(accountEntityDTO2);
        accountEntityDTO2.setId(2L);
        assertThat(accountEntityDTO1).isNotEqualTo(accountEntityDTO2);
        accountEntityDTO1.setId(null);
        assertThat(accountEntityDTO1).isNotEqualTo(accountEntityDTO2);
    }
}
