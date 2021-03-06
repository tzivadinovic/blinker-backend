package rs.prod.blinker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.prod.blinker.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}