package rs.prod.blinker.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.prod.blinker.entity.Customer;
import rs.prod.blinker.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {
	private final CustomerService customerService;

	@GetMapping
	public ResponseEntity<List<Customer>> getAllCustomers() {
		return ResponseEntity.ok(customerService.findAll());
	}

	@GetMapping("/{customerId}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable Integer customerId) {
		return ResponseEntity.ok(customerService.findById(customerId));
	}

	@PostMapping
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
		return ResponseEntity.status(HttpStatus.CREATED).body(customerService.save(customer));
	}

	@PutMapping
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
		return ResponseEntity.ok(customerService.update(customer));
	}

	@DeleteMapping("/{customerId}")
	public void deleteCustomerById(@PathVariable Integer customerId) {
		customerService.deleteById(customerId);
	}

}

