package rs.prod.blinker.service;

import java.util.Collection;
import java.util.List;
import rs.prod.blinker.entity.*;

public interface UserService {

	List<User> findAll();

	User save(User user);

	User update(User user);

	User findById(Integer userId);

	void deleteById(Integer userId);

}