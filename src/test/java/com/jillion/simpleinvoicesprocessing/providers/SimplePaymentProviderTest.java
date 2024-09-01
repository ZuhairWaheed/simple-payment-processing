package com.jillion.simpleinvoicesprocessing.providers;

import com.jillion.simpleinvoicesprocessing.providers.api.PaymentDetails;
import com.jillion.simpleinvoicesprocessing.providers.api.PaymentId;
import com.jillion.simpleinvoicesprocessing.providers.api.PaymentStatus;
import com.jillion.simpleinvoicesprocessing.providers.simple.SimplePaymentProvider;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class SimplePaymentProviderTest {

    private final PaymentProvider paymentProvider = new SimplePaymentProvider();

    @Test
    void pay() {
        PaymentId paymentId = paymentProvider.pay(new PaymentDetails(UUID.randomUUID(), "1234 1234 1234 0000", "John Doe", "12/24", "123", "100", "USD", "1234567890"));
        assertThat(paymentId).isNotNull();
    }

    @Test
    void byId() {
        PaymentId paymentId = paymentProvider.pay(new PaymentDetails(UUID.randomUUID(), "1234 1234 1234 0000", "John Doe", "12/24", "123", "100", "USD", "1234567890"));
        assertThat(paymentProvider.byId(paymentId)).isEqualTo(PaymentStatus.PAYMENT_STATUS_SUCCESS);
    }

    @Test
    void byIdPendingStatus() {
        PaymentId paymentId = paymentProvider.pay(new PaymentDetails(UUID.randomUUID(), "1234 1234 1234 1010", "John Doe", "12/24", "123", "100", "USD", "1234567890"));
        assertThat(paymentProvider.byId(paymentId)).isEqualTo(PaymentStatus.PAYMENT_STATUS_PENDING);
    }

    @Test
    void byIdInsufficientFunds() {
        PaymentId paymentId = paymentProvider.pay(new PaymentDetails(UUID.randomUUID(), "1234 1234 1234 1212", "John Doe", "12/24", "123", "100", "USD", "1234567890"));
        assertThat(paymentProvider.byId(paymentId)).isEqualTo(PaymentStatus.PAYMENT_STATUS_INSUFFICIENT_FUNDS);
    }

    @Test
    void byIdDoNotHonor() {
        PaymentId paymentId = paymentProvider.pay(new PaymentDetails(UUID.randomUUID(), "1234 1234 1234 2323", "John Doe", "12/24", "123", "100", "USD", "1234567890"));
        assertThat(paymentProvider.byId(paymentId)).isEqualTo(PaymentStatus.PAYMENT_STATUS_DO_NOT_HONOR);
    }

    @Test
    void byIdDeclined() {
        PaymentId paymentId = paymentProvider.pay(new PaymentDetails(UUID.randomUUID(), "1234 1234 1234 3434", "John Doe", "12/24", "123", "100", "USD", "1234567890"));
        assertThat(paymentProvider.byId(paymentId)).isEqualTo(PaymentStatus.PAYMENT_STATUS_DECLINED);
    }

    @Test
    void byReferenceID() {
        PaymentId paymentId = paymentProvider.pay(new PaymentDetails(UUID.randomUUID(), "1234 1234 1234 0000", "John Doe", "12/24", "123", "100", "USD", "1234567890"));
        assertThat(paymentProvider.byId(paymentId)).isEqualTo(PaymentStatus.PAYMENT_STATUS_SUCCESS);
    }
}