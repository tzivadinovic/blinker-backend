package rs.prod.blinker.service;

import rs.prod.blinker.entity.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> findAll();

    Customer save(Customer customer);

    Customer update(Customer customer);

    Customer findById(Integer customerId);

    void deleteById(Integer customerId);

}