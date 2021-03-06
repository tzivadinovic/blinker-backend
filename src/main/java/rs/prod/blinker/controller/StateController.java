package rs.prod.blinker.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.prod.blinker.entity.State;
import rs.prod.blinker.service.StateService;

import java.util.List;

@RestController
@RequestMapping("/states")
@RequiredArgsConstructor
public class StateController {
	private final StateService stateService;

	@GetMapping
	public ResponseEntity<List<State>> getAllStates() {
		return ResponseEntity.ok(stateService.findAll());
	}

	@GetMapping("/{stateId}")
	public ResponseEntity<State> getStateById(@PathVariable Integer stateId) {
		return ResponseEntity.ok(stateService.findById(stateId));
	}

	@PostMapping
	public ResponseEntity<State> saveState(@RequestBody State state) {
		return ResponseEntity.status(HttpStatus.CREATED).body(stateService.save(state));
	}

	@PutMapping
	public ResponseEntity<State> updateState(@RequestBody State state) {
		return ResponseEntity.ok(stateService.update(state));
	}

	@DeleteMapping("/{stateId}")
	public void deleteStateById(@PathVariable Integer stateId) {
		stateService.deleteById(stateId);
	}

}

