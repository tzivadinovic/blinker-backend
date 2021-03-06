package rs.prod.blinker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.prod.blinker.entity.Currency;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Integer> {

}