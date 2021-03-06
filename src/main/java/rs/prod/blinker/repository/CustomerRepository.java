package rs.prod.blinker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.prod.blinker.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}