package rs.prod.blinker.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.prod.blinker.entity.InvoiceDetails;
import rs.prod.blinker.service.InvoiceDetailsService;

import java.util.List;

@RestController
@RequestMapping("/invoice-detailses")
@RequiredArgsConstructor
public class InvoiceDetailsController {
	private final InvoiceDetailsService invoiceDetailsService;

	@GetMapping
	public ResponseEntity<List<InvoiceDetails>> getAllInvoiceDetailses() {
		return ResponseEntity.ok(invoiceDetailsService.findAll());
	}

	@GetMapping("/{invoiceDetailId}")
	public ResponseEntity<InvoiceDetails> getInvoiceDetailsById(@PathVariable Integer invoiceDetailId) {
		return ResponseEntity.ok(invoiceDetailsService.findById(invoiceDetailId));
	}

	@PostMapping
	public ResponseEntity<InvoiceDetails> saveInvoiceDetails(@RequestBody InvoiceDetails invoiceDetails) {
		return ResponseEntity.status(HttpStatus.CREATED).body(invoiceDetailsService.save(invoiceDetails));
	}

	@PutMapping
	public ResponseEntity<InvoiceDetails> updateInvoiceDetails(@RequestBody InvoiceDetails invoiceDetails) {
		return ResponseEntity.ok(invoiceDetailsService.update(invoiceDetails));
	}

	@DeleteMapping("/{invoiceDetailId}")
	public void deleteInvoiceDetailsById(@PathVariable Integer invoiceDetailId) {
		invoiceDetailsService.deleteById(invoiceDetailId);
	}

}

