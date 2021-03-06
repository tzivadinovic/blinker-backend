package rs.prod.blinker.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import lombok.*;
import org.springframework.stereotype.Service;
import rs.prod.blinker.entity.*;
import rs.prod.blinker.repository.ProductInvoiceRepository;
import rs.prod.blinker.service.ProductInvoiceService;

@Data
@Service
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class ProductInvoiceServiceImpl implements ProductInvoiceService {
	private final ProductInvoiceRepository productInvoiceRepository;

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


}