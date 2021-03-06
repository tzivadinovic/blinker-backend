package rs.prod.blinker.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import rs.prod.blinker.entity.TransportTerm;

@Repository
public interface TransportTermRepository extends JpaRepository<TransportTerm, Integer> {

}