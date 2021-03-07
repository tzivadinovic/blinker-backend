package rs.prod.blinker.service;

import rs.prod.blinker.entity.Product;

import java.util.List;

public interface ProductService {

	List<Product> findAll();

	Product save(Product product);

	Product update(Product product);

	Product findById(Integer productId);

	void deleteById(Integer productId);

	Product findByCode(String code);

}