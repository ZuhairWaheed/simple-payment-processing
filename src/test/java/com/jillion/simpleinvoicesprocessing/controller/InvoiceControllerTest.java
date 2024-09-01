package com.jillion.simpleinvoicesprocessing.controller;


import com.jillion.simpleinvoicesprocessing.providers.controller.InvoiceController;
import com.jillion.simpleinvoicesprocessing.providers.dto.CreateInvoiceDto;
import com.jillion.simpleinvoicesprocessing.providers.service.InvoiceService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class InvoiceControllerTest {

    private final InvoiceController invoiceController = new InvoiceController();
    private final InvoiceService invoiceService= new InvoiceService();

    @Test
    public void createInvoiceTest()
    {
        CreateInvoiceDto createInvoiceDto = new CreateInvoiceDto("merchant-id","customer-id",10.0,"USD", Optional.of("description"));
        UUID invoiceId = invoiceController.createInvoice(createInvoiceDto);
        Assertions.assertNotNull(invoiceId);
    }

}
