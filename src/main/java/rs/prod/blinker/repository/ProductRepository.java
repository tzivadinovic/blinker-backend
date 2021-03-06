package rs.prod.blinker.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import rs.prod.blinker.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}