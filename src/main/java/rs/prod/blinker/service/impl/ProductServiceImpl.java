package rs.prod.blinker.service.impl;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rs.prod.blinker.entity.Product;
import rs.prod.blinker.repository.ProductRepository;
import rs.prod.blinker.service.ProductService;

import java.util.List;
import java.util.NoSuchElementException;

@Data
@Service
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class ProductServiceImpl implements ProductService {
	private final ProductRepository productRepository;

	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	public Product findById(Integer productId) {
		return productRepository.findById(productId)
				.orElseThrow(() -> new NoSuchElementException("ProductService.notFound"));
	}

	@Override
	public Product save(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product update(Product product) {
		return productRepository.save(product);
	}

	@Override
	public void deleteById(Integer productId) {
		productRepository.deleteById(productId);
	}

	@Override
	public Product findByCode(String code) {
		return productRepository.findByCode(code).orElseThrow(() -> new NoSuchElementException("ProductService.productByCode.notFound"));
	}


}