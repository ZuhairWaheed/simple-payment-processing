package com.jillion.simpleinvoicesprocessing.providers.dto;

import java.util.Optional;

public class CreateInvoiceDto {
    private String merchantId;
    private String customerId;
    private Double amount;
    private String currency;
    private Optional<String> description;

    public CreateInvoiceDto(String merchantId, String customerId, Double amount, String currency, Optional<String> description) {
        this.merchantId = merchantId;
        this.customerId = customerId;
        this.amount = amount;
        this.currency = currency;
        this.description = description;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public Double getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public Optional<String> getDescription() {
        return description;
    }
}
