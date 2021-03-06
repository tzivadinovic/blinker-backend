package rs.prod.blinker.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import rs.prod.blinker.entity.City;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

}