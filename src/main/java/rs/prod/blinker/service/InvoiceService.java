package rs.prod.blinker.service;

import java.util.Collection;
import java.util.List;
import rs.prod.blinker.entity.*;

public interface InvoiceService {

	List<Invoice> findAll();

	Invoice save(Invoice invoice);

	Invoice update(Invoice invoice);

	Invoice findById(Integer invoiceId);

	void deleteById(Integer invoiceId);

}