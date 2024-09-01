package com.jillion.simpleinvoicesprocessing.providers.api;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Getter
@EqualsAndHashCode
@RequiredArgsConstructor
public class PaymentId {
    private final UUID id;

    public static PaymentId newId() {
        return new PaymentId(UUID.randomUUID());
    }
}
