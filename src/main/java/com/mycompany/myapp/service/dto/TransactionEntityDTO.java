package com.mycompany.myapp.service.dto;

import java.time.Instant;
import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;
import com.mycompany.myapp.domain.enumeration.TransType;

/**
 * A DTO for the {@link com.mycompany.myapp.domain.TransactionEntity} entity.
 */
public class TransactionEntityDTO implements Serializable {
    
    private Long id;

    @NotNull
    private Double transAmmount;

    @NotNull
    private LocalDate transDate;

    @NotNull
    private TransType transType;

    private Instant entryDate;


    private Long accountEntityId;

    private String accountEntityCode;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getTransAmmount() {
        return transAmmount;
    }

    public void setTransAmmount(Double transAmmount) {
        this.transAmmount = transAmmount;
    }

    public LocalDate getTransDate() {
        return transDate;
    }

    public void setTransDate(LocalDate transDate) {
        this.transDate = transDate;
    }

    public TransType getTransType() {
        return transType;
    }

    public void setTransType(TransType transType) {
        this.transType = transType;
    }

    public Instant getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Instant entryDate) {
        this.entryDate = entryDate;
    }

    public Long getAccountEntityId() {
        return accountEntityId;
    }

    public void setAccountEntityId(Long accountEntityId) {
        this.accountEntityId = accountEntityId;
    }

    public String getAccountEntityCode() {
        return accountEntityCode;
    }

    public void setAccountEntityCode(String accountEntityCode) {
        this.accountEntityCode = accountEntityCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TransactionEntityDTO)) {
            return false;
        }

        return id != null && id.equals(((TransactionEntityDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TransactionEntityDTO{" +
            "id=" + getId() +
            ", transAmmount=" + getTransAmmount() +
            ", transDate='" + getTransDate() + "'" +
            ", transType='" + getTransType() + "'" +
            ", entryDate='" + getEntryDate() + "'" +
            ", accountEntityId=" + getAccountEntityId() +
            ", accountEntityCode='" + getAccountEntityCode() + "'" +
            "}";
    }
}
