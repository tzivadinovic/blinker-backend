package rs.prod.blinker.service.impl;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rs.prod.blinker.entity.Customer;
import rs.prod.blinker.repository.CustomerRepository;
import rs.prod.blinker.service.CustomerService;

import java.util.List;
import java.util.NoSuchElementException;

@Data
@Service
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class CustomerServiceImpl implements CustomerService {
	private final CustomerRepository customerRepository;

	@Override
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	@Override
	public Customer findById(Integer customerId) {
		return customerRepository.findById(customerId)
				.orElseThrow(() -> new NoSuchElementException("CustomerService.notFound"));
	}

	@Override
	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public Customer update(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public void deleteById(Integer customerId) {
		customerRepository.deleteById(customerId);
	}


}