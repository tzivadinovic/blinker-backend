package rs.prod.blinker.service;

import rs.prod.blinker.entity.ProductInvoice;

import java.util.List;

public interface ProductInvoiceService {

	List<ProductInvoice> findAll();

	ProductInvoice save(ProductInvoice productInvoice);

	ProductInvoice update(ProductInvoice productInvoice);

	ProductInvoice findById(Integer productInvoiceId);

	void deleteById(Integer productInvoiceId);

	List<ProductInvoice> findByInvoiceId(Integer invoiceId);

}