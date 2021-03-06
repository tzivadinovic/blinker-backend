package rs.prod.blinker.service;

import java.util.Collection;
import java.util.List;
import rs.prod.blinker.entity.*;

public interface ProductInvoiceService {

	List<ProductInvoice> findAll();

	ProductInvoice save(ProductInvoice productInvoice);

	ProductInvoice update(ProductInvoice productInvoice);

	ProductInvoice findById(Integer productInvoiceId);

	void deleteById(Integer productInvoiceId);

}