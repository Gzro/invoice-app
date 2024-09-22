package com.example.invoiceapp;

import com.example.invoiceapp.model.Invoice;
import com.example.invoiceapp.repository.InvoiceRepository;
import com.example.invoiceapp.service.InvoiceService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

class InvoiceServiceTest {

    private final InvoiceRepository invoiceRepository = Mockito.mock(InvoiceRepository.class);
    private final InvoiceService invoiceService = new InvoiceService(invoiceRepository);

    @Test
    void testGetAllInvoices() {
        Invoice invoice1 = new Invoice("Consulting", 500.0, false);
        Invoice invoice2 = new Invoice("Development", 1000.0, true);

        Mockito.when(invoiceRepository.findAll()).thenReturn(Arrays.asList(invoice1, invoice2));

        List<Invoice> invoices = invoiceService.getAllInvoices();

        assertEquals(2, invoices.size());
    }
}
