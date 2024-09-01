package com.jillion.simpleinvoicesprocessing.providers.api;

public enum PaymentStatus {
    PAYMENT_STATUS_UNKNOWN,
    PAYMENT_STATUS_PENDING,
    PAYMENT_STATUS_SUCCESS,
    PAYMENT_STATUS_INSUFFICIENT_FUNDS,
    PAYMENT_STATUS_DO_NOT_HONOR,
    PAYMENT_STATUS_DECLINED,
}
