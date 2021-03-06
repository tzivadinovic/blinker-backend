package rs.prod.blinker.service;

import java.util.Collection;
import java.util.List;
import rs.prod.blinker.entity.*;

public interface CurrencyService {

	List<Currency> findAll();

	Currency save(Currency currency);

	Currency update(Currency currency);

	Currency findById(Integer currencyId);

	void deleteById(Integer currencyId);

}