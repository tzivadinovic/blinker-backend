package rs.prod.blinker.service;

import rs.prod.blinker.entity.Invoice;

import java.util.List;

public interface InvoiceService {

	List<Invoice> findAll();

	Invoice save();

	Invoice update(Invoice invoice);

	Invoice findById(Integer invoiceId);

	void deleteById(Integer invoiceId);

	Invoice findLastCreated();

}