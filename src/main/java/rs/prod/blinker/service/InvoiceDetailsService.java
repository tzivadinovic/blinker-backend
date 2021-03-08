package rs.prod.blinker.service;

import rs.prod.blinker.entity.InvoiceDetails;

import java.util.List;

public interface InvoiceDetailsService {

    List<InvoiceDetails> findAll();

    InvoiceDetails save(InvoiceDetails invoiceDetails);

    InvoiceDetails update(InvoiceDetails invoiceDetails);

    InvoiceDetails findById(Integer invoiceDetailId);

    void deleteById(Integer invoiceDetailId);

}