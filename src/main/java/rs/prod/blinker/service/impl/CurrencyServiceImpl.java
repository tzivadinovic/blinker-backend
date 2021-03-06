package rs.prod.blinker.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import lombok.*;
import org.springframework.stereotype.Service;
import rs.prod.blinker.entity.*;
import rs.prod.blinker.repository.CurrencyRepository;
import rs.prod.blinker.service.CurrencyService;

@Data
@Service
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class CurrencyServiceImpl implements CurrencyService {
	private final CurrencyRepository currencyRepository;

	@Override
	public List<Currency> findAll() {
		return currencyRepository.findAll();
	}

	@Override
	public Currency findById(Integer currencyId) {
		return currencyRepository.findById(currencyId)
				.orElseThrow(() -> new NoSuchElementException("CurrencyService.notFound"));
	}

	@Override
	public Currency save(Currency currency) {
		return currencyRepository.save(currency);
	}

	@Override
	public Currency update(Currency currency) {
		return currencyRepository.save(currency);
	}

	@Override
	public void deleteById(Integer currencyId) {
		currencyRepository.deleteById(currencyId);
	}


}