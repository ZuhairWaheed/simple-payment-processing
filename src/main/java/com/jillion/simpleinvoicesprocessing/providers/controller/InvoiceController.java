package com.jillion.simpleinvoicesprocessing.providers.controller;

import com.jillion.simpleinvoicesprocessing.providers.dto.CreateInvoiceDto;
import com.jillion.simpleinvoicesprocessing.providers.service.InvoiceService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

    private final InvoiceService invoiceService = new InvoiceService();

    @PostMapping("/create")
    public UUID createInvoice(@RequestBody CreateInvoiceDto invoice) {
        return invoiceService.createInvoice(invoice);
    }


}
