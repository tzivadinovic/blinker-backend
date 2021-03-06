package rs.prod.blinker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.prod.blinker.entity.State;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {

}