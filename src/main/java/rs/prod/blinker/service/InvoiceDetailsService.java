package rs.prod.blinker.service;

import java.util.Collection;
import java.util.List;
import rs.prod.blinker.entity.*;

public interface InvoiceDetailsService {

	List<InvoiceDetails> findAll();

	InvoiceDetails save(InvoiceDetails invoiceDetails);

	InvoiceDetails update(InvoiceDetails invoiceDetails);

	InvoiceDetails findById(Integer invoiceDetailId);

	void deleteById(Integer invoiceDetailId);

}