package rs.prod.blinker.service;

import java.util.Collection;
import java.util.List;
import rs.prod.blinker.entity.*;

public interface ProductService {

	List<Product> findAll();

	Product save(Product product);

	Product update(Product product);

	Product findById(Integer productId);

	void deleteById(Integer productId);

}