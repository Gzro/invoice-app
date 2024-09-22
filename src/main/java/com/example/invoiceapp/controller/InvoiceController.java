package com.example.invoiceapp.controller;

import com.example.invoiceapp.model.Invoice;
import com.example.invoiceapp.service.InvoiceService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invoices")
public class InvoiceController {

    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @Operation(summary = "Get all invoices")
    @GetMapping
    public List<Invoice> getAllInvoices() {
        return invoiceService.getAllInvoices();
    }

    @Operation(summary = "Create a new invoice")
    @PostMapping
    public Invoice createInvoice(@RequestBody Invoice invoice) {
        return invoiceService.createInvoice(invoice);
    }

    @Operation(summary = "Update an invoice")
    @PutMapping("/{id}")
    public Invoice updateInvoice(@PathVariable Long id, @RequestBody Invoice invoice) {
        return invoiceService.updateInvoice(id, invoice);
    }

    @Operation(summary = "Delete an invoice")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteInvoice(@PathVariable Long id) {
        invoiceService.deleteInvoice(id);
        return ResponseEntity.ok().build();
    }
    
    @Operation(summary = "Get an invoice by id")
    @GetMapping("/{id}")
    public Invoice findInvoiceById(@PathVariable Long id) {
        return invoiceService.getInvoiceById(id);
    }
}
