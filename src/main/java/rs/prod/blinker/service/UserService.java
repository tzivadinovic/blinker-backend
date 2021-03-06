package rs.prod.blinker.service;

import rs.prod.blinker.entity.User;

import java.util.List;

public interface UserService {

	List<User> findAll();

	User save(User user);

	User update(User user);

	User findById(Integer userId);

	void deleteById(Integer userId);

}