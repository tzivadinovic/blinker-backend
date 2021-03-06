package rs.prod.blinker.controller;

import java.util.List;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.prod.blinker.entity.*;
import rs.prod.blinker.service.*;

@RestController
@RequestMapping("/invoices")
@RequiredArgsConstructor
public class InvoiceController {
	private final InvoiceService invoiceService;

	@GetMapping
	public ResponseEntity<List<Invoice>> getAllInvoices() {
		return ResponseEntity.ok(invoiceService.findAll());
	}

	@GetMapping("/{invoiceId}")
	public ResponseEntity<Invoice> getInvoiceById(@PathVariable Integer invoiceId) {
		return ResponseEntity.ok(invoiceService.findById(invoiceId));
	}

	@PostMapping
	public ResponseEntity<Invoice> saveInvoice(@RequestBody Invoice invoice) {
		return ResponseEntity.status(HttpStatus.CREATED).body(invoiceService.save(invoice));
	}

	@PutMapping
	public ResponseEntity<Invoice> updateInvoice(@RequestBody Invoice invoice) {
		return ResponseEntity.ok(invoiceService.update(invoice));
	}

	@DeleteMapping("/{invoiceId}")
	public void deleteInvoiceById(@PathVariable Integer invoiceId) {
		invoiceService.deleteById(invoiceId);
	}

}

