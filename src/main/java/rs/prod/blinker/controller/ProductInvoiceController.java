package rs.prod.blinker.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.prod.blinker.entity.ProductInvoice;
import rs.prod.blinker.service.ProductInvoiceService;

import java.util.List;

@RestController
@RequestMapping("/product-invoices")
@RequiredArgsConstructor
public class ProductInvoiceController {
	private final ProductInvoiceService productInvoiceService;

	@GetMapping
	public ResponseEntity<List<ProductInvoice>> getAllProductInvoices() {
		return ResponseEntity.ok(productInvoiceService.findAll());
	}

	@GetMapping("/{productInvoiceId}")
	public ResponseEntity<ProductInvoice> getProductInvoiceById(@PathVariable Integer productInvoiceId) {
		return ResponseEntity.ok(productInvoiceService.findById(productInvoiceId));
	}

	@PostMapping
	public ResponseEntity<ProductInvoice> saveProductInvoice(@RequestBody ProductInvoice productInvoice) {
		return ResponseEntity.status(HttpStatus.CREATED).body(productInvoiceService.save(productInvoice));
	}

	@PutMapping
	public ResponseEntity<ProductInvoice> updateProductInvoice(@RequestBody ProductInvoice productInvoice) {
		return ResponseEntity.ok(productInvoiceService.update(productInvoice));
	}

	@DeleteMapping("/{productInvoiceId}")
	public void deleteProductInvoiceById(@PathVariable Integer productInvoiceId) {
		productInvoiceService.deleteById(productInvoiceId);
	}

}

