package com.jillion.simpleinvoicesprocessing.providers.service;

import com.jillion.simpleinvoicesprocessing.providers.dto.CreateInvoiceDto;
import com.jillion.simpleinvoicesprocessing.providers.model.Invoice;
import com.jillion.simpleinvoicesprocessing.providers.repository.InvoiceRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class InvoiceService {

    private InvoiceRepository invoiceRepository;

    public UUID createInvoice(CreateInvoiceDto invoice)
    {
        Invoice requestInvoice = new Invoice(invoice.getCustomerId(),invoice.getMerchantId(),invoice.getAmount(),invoice.getCurrency(),invoice.getDescription());
        Invoice createdInvoice = invoiceRepository.save(requestInvoice);
        return createdInvoice.getId();
    }
}
