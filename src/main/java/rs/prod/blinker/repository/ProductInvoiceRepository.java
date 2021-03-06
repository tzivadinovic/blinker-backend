package rs.prod.blinker.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import rs.prod.blinker.entity.ProductInvoice;

@Repository
public interface ProductInvoiceRepository extends JpaRepository<ProductInvoice, Integer> {

}