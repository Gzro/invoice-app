package com.example.invoiceapp.service;

import com.example.invoiceapp.model.Invoice;
import com.example.invoiceapp.repository.InvoiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;

    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    public Invoice createInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    public Invoice updateInvoice(Long id, Invoice updatedInvoice) {
        return invoiceRepository.findById(id)
                .map(invoice -> {
                    invoice.setDescription(updatedInvoice.getDescription());
                    invoice.setAmount(updatedInvoice.getAmount());
                    invoice.setPaid(updatedInvoice.isPaid());
                    return invoiceRepository.save(invoice);
                })
                .orElseThrow(() -> new RuntimeException("Invoice not found"));
    }

    public void deleteInvoice(Long id) {
        invoiceRepository.deleteById(id);
    }
    
    public Invoice getInvoiceById(Long id) {
        return invoiceRepository.findById(id).get();
    }
}
