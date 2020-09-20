package com.mycompany.myapp.service.dto;

import java.time.Instant;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.mycompany.myapp.domain.AccountEntity} entity.
 */
public class AccountEntityDTO implements Serializable {
    
    private Long id;

    
    private Integer code;

    @NotNull
    private String accountEntityName;

    @NotNull
    private String description;

    @NotNull
    private Double openingBalance;

    private Double closingBalance;

    private Instant createdAt;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getAccountEntityName() {
        return accountEntityName;
    }

    public void setAccountEntityName(String accountEntityName) {
        this.accountEntityName = accountEntityName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getOpeningBalance() {
        return openingBalance;
    }

    public void setOpeningBalance(Double openingBalance) {
        this.openingBalance = openingBalance;
    }

    public Double getClosingBalance() {
        return closingBalance;
    }

    public void setClosingBalance(Double closingBalance) {
        this.closingBalance = closingBalance;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AccountEntityDTO)) {
            return false;
        }

        return id != null && id.equals(((AccountEntityDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AccountEntityDTO{" +
            "id=" + getId() +
            ", code=" + getCode() +
            ", accountEntityName='" + getAccountEntityName() + "'" +
            ", description='" + getDescription() + "'" +
            ", openingBalance=" + getOpeningBalance() +
            ", closingBalance=" + getClosingBalance() +
            ", createdAt='" + getCreatedAt() + "'" +
            "}";
    }
}
