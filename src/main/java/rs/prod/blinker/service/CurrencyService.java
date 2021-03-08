package rs.prod.blinker.service;

import rs.prod.blinker.entity.Currency;

import java.util.List;

public interface CurrencyService {

    List<Currency> findAll();

    Currency save(Currency currency);

    Currency update(Currency currency);

    Currency findById(Integer currencyId);

    void deleteById(Integer currencyId);

}