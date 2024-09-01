package com.jillion.simpleinvoicesprocessing.providers.model;

import com.jillion.simpleinvoicesprocessing.providers.dto.CreateInvoiceDto;
import jakarta.persistence.Entity;

import java.util.Optional;
import java.util.UUID;

@Entity
public class Invoice {

    private UUID id;
    private String merchantId;
    private String customerId;
    private Double amount;
    private String currency;
    private Optional<String> description;

    public Invoice(String merchantId, String customerId, Double amount, String currency, Optional<String> description) {
        this.merchantId = merchantId;
        this.customerId = customerId;
        this.amount = amount;
        this.currency = currency;
        this.description = description;
    }

    public UUID getId() {
        return id;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public String getCustomerId() {
        return customerId;
    }
}
