package com.jillion.simpleinvoicesprocessing.providers.simple;

import com.jillion.simpleinvoicesprocessing.providers.PaymentProvider;
import com.jillion.simpleinvoicesprocessing.providers.api.PaymentDetails;
import com.jillion.simpleinvoicesprocessing.providers.api.PaymentId;
import com.jillion.simpleinvoicesprocessing.providers.api.PaymentStatus;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.Duration;
import java.time.Instant;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class SimplePaymentProvider implements PaymentProvider {

    private static final Duration PAYMENT_PROCESSING_TIME = Duration.ofSeconds(5);
    private final Map<PaymentId, PaymentData> paymentsStore = new ConcurrentHashMap<>();

    public PaymentId pay(PaymentDetails paymentDetails) {
        PaymentId paymentId = PaymentId.newId();
        paymentsStore.put(paymentId, new PaymentData(paymentDetails, Instant.now()));
        return paymentId;
    }

    public PaymentStatus byId(PaymentId paymentId) {
        PaymentData paymentData = paymentsStore.get(paymentId);
        if (paymentData == null) {
            return PaymentStatus.PAYMENT_STATUS_UNKNOWN;
        } else if (paymentData.paymentDetails.getCardNumber().endsWith("1010") && Duration.between(paymentData.timestamp, Instant.now()).compareTo(PAYMENT_PROCESSING_TIME) < 0) {
            return PaymentStatus.PAYMENT_STATUS_PENDING;
        } else if (paymentData.paymentDetails.getCardNumber().endsWith("1212")) {
            return PaymentStatus.PAYMENT_STATUS_INSUFFICIENT_FUNDS;
        } else if (paymentData.paymentDetails.getCardNumber().endsWith("2323")) {
            return PaymentStatus.PAYMENT_STATUS_DO_NOT_HONOR;
        } else if (paymentData.paymentDetails.getCardNumber().endsWith("3434")) {
            return PaymentStatus.PAYMENT_STATUS_DECLINED;
        } else if (paymentData.paymentDetails.getCardNumber().endsWith("4545")) {
            LockSupport.parkNanos(TimeUnit.HOURS.toNanos(1));
            return PaymentStatus.PAYMENT_STATUS_DECLINED;
        }
        return PaymentStatus.PAYMENT_STATUS_SUCCESS;
    }

    public PaymentStatus byReferenceId(UUID referenceId) {
        return paymentsStore.entrySet().stream()
                .filter(entry -> entry.getValue().paymentDetails.getReferenceId().equals(referenceId))
                .map(Map.Entry::getKey)
                .findFirst()
                .map(this::byId)
                .orElse(PaymentStatus.PAYMENT_STATUS_UNKNOWN);
    }

    @Getter
    @RequiredArgsConstructor
    static class PaymentData {
        private final PaymentDetails paymentDetails;
        private final Instant timestamp;
    }
}
