package com.jillion.simpleinvoicesprocessing.providers;

import com.jillion.simpleinvoicesprocessing.providers.api.PaymentDetails;
import com.jillion.simpleinvoicesprocessing.providers.api.PaymentId;
import com.jillion.simpleinvoicesprocessing.providers.api.PaymentStatus;

import java.util.UUID;

public interface PaymentProvider {
    PaymentId pay(PaymentDetails paymentDetails);

    PaymentStatus byId(PaymentId paymentId);

    PaymentStatus byReferenceId(UUID referenceId);
}
