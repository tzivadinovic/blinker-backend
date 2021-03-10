package rs.prod.blinker.service.impl;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rs.prod.blinker.entity.Invoice;
import rs.prod.blinker.entity.InvoiceDetails;
import rs.prod.blinker.entity.ProductInvoice;
import rs.prod.blinker.repository.InvoiceDetailsRepository;
import rs.prod.blinker.repository.InvoiceRepository;
import rs.prod.blinker.repository.ProductInvoiceRepository;
import rs.prod.blinker.repository.ProductRepository;
import rs.prod.blinker.service.InvoiceService;
import rs.prod.blinker.service.ProductInvoiceService;

import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

@Data
@Service
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class ProductInvoiceServiceImpl implements ProductInvoiceService {
    private final ProductInvoiceRepository productInvoiceRepository;
    private final InvoiceRepository invoiceRepository;
    private final ProductRepository productRepository;
    private final InvoiceService invoiceService;
    private final InvoiceDetailsRepository invoiceDetailsRepository;

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
        InvoiceDetails invoiceDetails = invoice.getInvoiceDetail();
        productInvoice.setInvoice(invoice);
//        productInvoice.getProduct().setStock(productInvoice.getProduct().getStock() - productInvoice.getQuantity());
        productRepository.save(productInvoice.getProduct());
        double newValue = getInvoiceTotalValue(invoice.getId());
        newValue += productInvoice.getProduct().getPrice() * productInvoice.getQuantity();
        invoiceDetails.setTotalPrice(newValue);
        invoiceDetails.setTotalBoxes(totalBoxes(invoice.getId()));
        invoiceDetailsRepository.save(invoiceDetails);
        return productInvoiceRepository.save(productInvoice);
    }

    @Override
    public ProductInvoice update(ProductInvoice productInvoice) {
        Invoice invoice = invoiceRepository.findById(productInvoice.getInvoice().getId())
                .orElseThrow(() -> new NoSuchElementException("ProductInvoiceService.invoice.notFound"));
        productInvoice.setInvoice(invoice);
//        productInvoice.getProduct().setStock(productInvoice.getProduct().getStock() - productInvoice.getQuantity());
        productRepository.save(productInvoice.getProduct());
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

    @Override
    public Integer totalBoxes(Integer invoiceId) {
        Set<Integer> uniqueBoxes = new HashSet<>();
        for (ProductInvoice productInvoice : productInvoiceRepository.findAllByInvoiceId(invoiceId)) {
            uniqueBoxes.add(productInvoice.getBoxNumber());
        }
        return uniqueBoxes.size();
    }


}