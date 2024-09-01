package com.jillion.simpleinvoicesprocessing.providers.api;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Getter
@RequiredArgsConstructor
public class PaymentDetails {
    private final UUID referenceId;
    private final String CardNumber;
    private final String CardHolder;
    private final String Expiry;
    private final String CVC;
    private final String Amount;
    private final String CurrencyCode;
    private final String BankAccountNumber;
}
