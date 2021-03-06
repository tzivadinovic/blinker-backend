package rs.prod.blinker.controller;

import java.util.List;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.prod.blinker.entity.*;
import rs.prod.blinker.service.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
	private final UserService userService;

	@GetMapping
	public ResponseEntity<List<User>> getAllUsers() {
		return ResponseEntity.ok(userService.findAll());
	}

	@GetMapping("/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable Integer userId) {
		return ResponseEntity.ok(userService.findById(userId));
	}

	@PostMapping
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
	}

	@PutMapping
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		return ResponseEntity.ok(userService.update(user));
	}

	@DeleteMapping("/{userId}")
	public void deleteUserById(@PathVariable Integer userId) {
		userService.deleteById(userId);
	}

}

