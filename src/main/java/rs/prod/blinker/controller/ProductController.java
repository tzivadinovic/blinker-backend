package rs.prod.blinker.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.prod.blinker.entity.Product;
import rs.prod.blinker.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
	private final ProductService productService;

	@GetMapping
	public ResponseEntity<List<Product>> getAllProducts() {
		return ResponseEntity.ok(productService.findAll());
	}

	@GetMapping("/{productId}")
	public ResponseEntity<Product> getProductById(@PathVariable Integer productId) {
		return ResponseEntity.ok(productService.findById(productId));
	}

	@PostMapping
	public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
		return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(product));
	}

	@PutMapping
	public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
		return ResponseEntity.ok(productService.update(product));
	}

	@DeleteMapping("/{productId}")
	public void deleteProductById(@PathVariable Integer productId) {
		productService.deleteById(productId);
	}

}

