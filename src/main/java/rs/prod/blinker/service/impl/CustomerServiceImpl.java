package rs.prod.blinker.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import lombok.*;
import org.springframework.stereotype.Service;
import rs.prod.blinker.entity.*;
import rs.prod.blinker.repository.CustomerRepository;
import rs.prod.blinker.service.CustomerService;

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