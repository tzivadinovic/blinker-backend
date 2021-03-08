package rs.prod.blinker.service.impl;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rs.prod.blinker.entity.Invoice;
import rs.prod.blinker.entity.ProductInvoice;
import rs.prod.blinker.repository.InvoiceRepository;
import rs.prod.blinker.repository.ProductInvoiceRepository;
import rs.prod.blinker.service.ProductInvoiceService;

import java.util.List;
import java.util.NoSuchElementException;

@Data
@Service
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class ProductInvoiceServiceImpl implements ProductInvoiceService {
    private final ProductInvoiceRepository productInvoiceRepository;
    private final InvoiceRepository invoiceRepository;

    @Override
    public List<ProductInvoice> findAll() {
        return productInvoiceRepository.findAll();
    }

    @Override
    public ProductInvoice findById(Integer productInvoiceId) {
        return productInvoiceRepository.findById(productInvoiceId)
                .orElseThrow(() -> new NoSuchElementException("ProductInvoiceService.notFound"));
    }

    @Override
    public ProductInvoice save(ProductInvoice productInvoice) {
        Invoice invoice = invoiceRepository.findTopByOrderByIdDesc()
                .orElseThrow(() -> new NoSuchElementException("ProductInvoiceService.invoice.notFound"));
        productInvoice.setInvoice(invoice);
        return productInvoiceRepository.save(productInvoice);
    }

    @Override
    public ProductInvoice update(ProductInvoice productInvoice) {
        return productInvoiceRepository.save(productInvoice);
    }

    @Override
    public void deleteById(Integer productInvoiceId) {
        productInvoiceRepository.deleteById(productInvoiceId);
    }

    @Override
    public List<ProductInvoice> findByInvoiceId(Integer invoiceId) {
        return productInvoiceRepository.findAllByInvoiceId(invoiceId);
    }

    @Override
    public double getInvoiceTotalValue(Integer invoiceId) {
        return findByInvoiceId(invoiceId)
                .stream()
                .mapToDouble(pr -> pr.getProduct().getPrice() * pr.getQuantity())
                .sum();
    }


}