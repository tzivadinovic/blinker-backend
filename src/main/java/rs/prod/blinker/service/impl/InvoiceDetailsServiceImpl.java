package rs.prod.blinker.service.impl;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rs.prod.blinker.entity.Invoice;
import rs.prod.blinker.entity.InvoiceDetails;
import rs.prod.blinker.repository.InvoiceDetailsRepository;
import rs.prod.blinker.repository.InvoiceRepository;
import rs.prod.blinker.service.InvoiceDetailsService;

import java.util.List;
import java.util.NoSuchElementException;

@Data
@Service
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class InvoiceDetailsServiceImpl implements InvoiceDetailsService {
    private final InvoiceDetailsRepository invoiceDetailsRepository;
    private final InvoiceRepository invoiceRepository;

    @Override
    public List<InvoiceDetails> findAll() {
        return invoiceDetailsRepository.findAll();
    }

    @Override
    public InvoiceDetails findById(Integer invoiceDetailId) {
        return invoiceDetailsRepository.findById(invoiceDetailId)
                .orElseThrow(() -> new NoSuchElementException("InvoiceDetailsService.notFound"));
    }

    @Override
    public InvoiceDetails save(InvoiceDetails invoiceDetails) {
        Invoice invoice = invoiceRepository.findTopByOrderByIdDesc()
                .orElseThrow(() -> new NoSuchElementException("InvoiceDetailsService.lastCreatedInvoice.notFound"));
        invoiceDetails.setInvoice(invoice);
        invoiceDetailsRepository.save(invoiceDetails);
        invoice.setInvoiceDetail(invoiceDetails);
        invoiceRepository.save(invoice);
        return invoiceDetails;
    }

    @Override
    public InvoiceDetails update(InvoiceDetails invoiceDetails) {
        return invoiceDetailsRepository.save(invoiceDetails);
    }

    @Override
    public void deleteById(Integer invoiceDetailId) {
        invoiceDetailsRepository.deleteById(invoiceDetailId);
    }


}