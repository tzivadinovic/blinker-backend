package rs.prod.blinker.service.impl;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rs.prod.blinker.entity.Invoice;
import rs.prod.blinker.repository.InvoiceRepository;
import rs.prod.blinker.repository.ProductInvoiceRepository;
import rs.prod.blinker.service.InvoiceService;

import java.util.List;
import java.util.NoSuchElementException;

@Data
@Service
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class InvoiceServiceImpl implements InvoiceService {
    private final InvoiceRepository invoiceRepository;
    private final ProductInvoiceRepository productInvoiceRepository;

    @Override
    public List<Invoice> findAll() {
        updateTotalPrice();
        updateNetWeight();
        return invoiceRepository.findAll();
    }

    @Override
    public Invoice findById(Integer invoiceId) {
        return invoiceRepository.findById(invoiceId)
                .orElseThrow(() -> new NoSuchElementException("InvoiceService.notFound"));
    }

    @Override
    public Invoice save() {
        Invoice invoice = new Invoice();
        return invoiceRepository.save(invoice);
    }

    @Override
    public Invoice save(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    @Override
    public Invoice update(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    @Override
    public void deleteById(Integer invoiceId) {
        invoiceRepository.deleteById(invoiceId);
    }

    @Override
    public Invoice findLastCreated() {
        return invoiceRepository.findTopByOrderByIdDesc()
                .orElseThrow(() -> new NoSuchElementException("InvoiceService.lastCreatedInvoice.notFound"));
    }

    @Override
    public double getInvoiceTotalValue(Integer invoiceId) {
        return productInvoiceRepository.findAllByInvoiceId(invoiceId)
                .stream()
                .mapToDouble(pr -> pr.getProduct().getPrice() * pr.getQuantity())
                .sum();
    }

    @Override
    public void updateTotalPrice() {
        List<Invoice> invoices = invoiceRepository.findAll();
        for (Invoice invoice : invoices) {
            invoice.getInvoiceDetail().setTotalPrice(getInvoiceTotalValue(invoice.getId()));
            invoiceRepository.save(invoice);
        }
    }

    @Override
    public void updateNetWeight() {
        List<Invoice> invoices = invoiceRepository.findAll();
        for (Invoice invoice : invoices) {
            if (invoice.getInvoiceDetail().getGrossWeight() == null) {
                invoice.getInvoiceDetail().setGrossWeight(0.0);
            } else {
                invoice.getInvoiceDetail().setNetWeight(invoice.getInvoiceDetail().getGrossWeight() - (invoice.getInvoiceDetail().getTotalBoxes() * 0.5));
                invoiceRepository.save(invoice);

            }
        }
    }


}