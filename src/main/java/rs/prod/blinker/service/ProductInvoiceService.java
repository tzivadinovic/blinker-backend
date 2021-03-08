package rs.prod.blinker.service;

import rs.prod.blinker.entity.Invoice;
import rs.prod.blinker.entity.ProductInvoice;

import java.util.List;
import java.util.Set;

public interface ProductInvoiceService {

    List<ProductInvoice> findAll();

    ProductInvoice save(ProductInvoice productInvoice);

    ProductInvoice update(ProductInvoice productInvoice);

    ProductInvoice findById(Integer productInvoiceId);

    void deleteById(Integer productInvoiceId);

    List<ProductInvoice> findByInvoiceId(Integer invoiceId);

    double getInvoiceTotalValue(Integer invoiceId);

    Integer totalBoxes(Integer invoiceId);

}