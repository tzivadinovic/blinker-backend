package rs.prod.blinker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.prod.blinker.entity.Invoice;
import rs.prod.blinker.entity.ProductInvoice;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductInvoiceRepository extends JpaRepository<ProductInvoice, Integer> {
    List<ProductInvoice> findAllByInvoiceId(Integer invoiceId);
}