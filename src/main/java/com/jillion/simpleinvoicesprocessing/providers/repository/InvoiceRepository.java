package com.jillion.simpleinvoicesprocessing.providers.repository;

import com.jillion.simpleinvoicesprocessing.providers.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, UUID> {

}
