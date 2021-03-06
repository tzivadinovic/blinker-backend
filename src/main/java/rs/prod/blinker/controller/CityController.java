package rs.prod.blinker.controller;

import java.util.List;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.prod.blinker.entity.*;
import rs.prod.blinker.service.*;

@RestController
@RequestMapping("/cities")
@RequiredArgsConstructor
public class CityController {
	private final CityService cityService;

	@GetMapping
	public ResponseEntity<List<City>> getAllCities() {
		return ResponseEntity.ok(cityService.findAll());
	}

	@GetMapping("/{cityId}")
	public ResponseEntity<City> getCityById(@PathVariable Integer cityId) {
		return ResponseEntity.ok(cityService.findById(cityId));
	}

	@PostMapping
	public ResponseEntity<City> saveCity(@RequestBody City city) {
		return ResponseEntity.status(HttpStatus.CREATED).body(cityService.save(city));
	}

	@PutMapping
	public ResponseEntity<City> updateCity(@RequestBody City city) {
		return ResponseEntity.ok(cityService.update(city));
	}

	@DeleteMapping("/{cityId}")
	public void deleteCityById(@PathVariable Integer cityId) {
		cityService.deleteById(cityId);
	}

}

