package rs.prod.blinker.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import rs.prod.blinker.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}