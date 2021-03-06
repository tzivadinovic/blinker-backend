package rs.prod.blinker.controller;

import io.swagger.annotations.ApiOperation;
import java.util.List;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.prod.blinker.entity.*;
import rs.prod.blinker.service.*;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {
	private final CustomerService customerService;

	@GetMapping
	@ApiOperation(value = "", nickname = "getAllCustomers")
	public ResponseEntity<List<Customer>> getAllCustomers() {
		return ResponseEntity.ok(customerService.findAll());
	}

	@GetMapping("/{customerId}")
	@ApiOperation(value = "", nickname = "getCustomerById")
	public ResponseEntity<Customer> getCustomerById(@PathVariable Integer customerId) {
		return ResponseEntity.ok(customerService.findById(customerId));
	}

	@PostMapping
	@ApiOperation(value = "", nickname = "saveCustomer")
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
		return ResponseEntity.status(HttpStatus.CREATED).body(customerService.save(customer));
	}

	@PutMapping
	@ApiOperation(value = "", nickname = "updateCustomer")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
		return ResponseEntity.ok(customerService.update(customer));
	}

	@DeleteMapping("/{customerId}")
	@ApiOperation(value = "", nickname = "deleteCustomerById")
	public void deleteCustomerById(@PathVariable Integer customerId) {
		customerService.deleteById(customerId);
	}

}

