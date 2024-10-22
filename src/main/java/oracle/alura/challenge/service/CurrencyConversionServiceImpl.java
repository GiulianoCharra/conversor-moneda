package oracle.alura.challenge.service;

import lombok.RequiredArgsConstructor;
import oracle.alura.challenge.model.CurrencyConversionResponse;
import oracle.alura.challenge.repository.CurrencyConversionRepository;

@RequiredArgsConstructor
public class CurrencyConversionServiceImpl implements CurrencyConversionService {
    private final CurrencyConversionRepository repository;

    @Override
    public CurrencyConversionResponse convertCurrency(String fromCurrency, String toCurrency, double amount) {
        return repository.getConversionRate(fromCurrency, toCurrency, amount);
    }
}
