package rs.prod.blinker.service.impl;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rs.prod.blinker.entity.User;
import rs.prod.blinker.repository.UserRepository;
import rs.prod.blinker.service.UserService;

import java.util.List;
import java.util.NoSuchElementException;

@Data
@Service
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User findById(Integer userId) {
		return userRepository.findById(userId)
				.orElseThrow(() -> new NoSuchElementException("UserService.notFound"));
	}

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public User update(User user) {
		return userRepository.save(user);
	}

	@Override
	public void deleteById(Integer userId) {
		userRepository.deleteById(userId);
	}


}