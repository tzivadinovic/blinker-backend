package rs.prod.blinker.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import lombok.*;
import org.springframework.stereotype.Service;
import rs.prod.blinker.entity.*;
import rs.prod.blinker.repository.InvoiceRepository;
import rs.prod.blinker.service.InvoiceService;

@Data
@Service
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class InvoiceServiceImpl implements InvoiceService {
	private final InvoiceRepository invoiceRepository;

	@Override
	public List<Invoice> findAll() {
		return invoiceRepository.findAll();
	}

	@Override
	public Invoice findById(Integer invoiceId) {
		return invoiceRepository.findById(invoiceId)
				.orElseThrow(() -> new NoSuchElementException("InvoiceService.notFound"));
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


}