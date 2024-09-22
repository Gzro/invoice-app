package com.example.invoiceapp.repository;

import com.example.invoiceapp.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
