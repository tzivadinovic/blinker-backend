package rs.prod.blinker.service.impl;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rs.prod.blinker.entity.Invoice;
import rs.prod.blinker.entity.InvoiceDetails;
import rs.prod.blinker.repository.InvoiceDetailsRepository;
import rs.prod.blinker.service.InvoiceDetailsService;
import rs.prod.blinker.service.InvoiceService;

import java.util.List;
import java.util.NoSuchElementException;

@Data
@Service
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class InvoiceDetailsServiceImpl implements InvoiceDetailsService {
    private final InvoiceDetailsRepository invoiceDetailsRepository;
    private final InvoiceService invoiceService;

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
        Invoice invoice;
        if (invoiceDetails.getInvoice() == null) {
            invoice = invoiceService.findLastCreated();
        } else {
            invoice = invoiceService.findById(invoiceDetails.getInvoice().getId());
        }
        invoice.setInvoiceDetail(invoiceDetails);
        invoice.getInvoiceDetail().setDate(invoiceDetails.getDate().plusDays(1));
        return invoiceService.save(invoice).getInvoiceDetail();

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