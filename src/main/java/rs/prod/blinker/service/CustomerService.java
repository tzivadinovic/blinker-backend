package rs.prod.blinker.service;

import java.util.Collection;
import java.util.List;
import rs.prod.blinker.entity.*;

public interface CustomerService {

	List<Customer> findAll();

	Customer save(Customer customer);

	Customer update(Customer customer);

	Customer findById(Integer customerId);

	void deleteById(Integer customerId);

}