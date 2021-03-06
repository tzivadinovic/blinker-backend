package rs.prod.blinker.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.prod.blinker.entity.Currency;
import rs.prod.blinker.service.CurrencyService;

import java.util.List;

@RestController
@RequestMapping("/currencies")
@RequiredArgsConstructor
public class CurrencyController {
	private final CurrencyService currencyService;

	@GetMapping
	public ResponseEntity<List<Currency>> getAllCurrencies() {
		return ResponseEntity.ok(currencyService.findAll());
	}

	@GetMapping("/{currencyId}")
	public ResponseEntity<Currency> getCurrencyById(@PathVariable Integer currencyId) {
		return ResponseEntity.ok(currencyService.findById(currencyId));
	}

	@PostMapping
	public ResponseEntity<Currency> saveCurrency(@RequestBody Currency currency) {
		return ResponseEntity.status(HttpStatus.CREATED).body(currencyService.save(currency));
	}

	@PutMapping
	public ResponseEntity<Currency> updateCurrency(@RequestBody Currency currency) {
		return ResponseEntity.ok(currencyService.update(currency));
	}

	@DeleteMapping("/{currencyId}")
	public void deleteCurrencyById(@PathVariable Integer currencyId) {
		currencyService.deleteById(currencyId);
	}

}

