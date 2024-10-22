package oracle.alura.challenge.repository;

import lombok.RequiredArgsConstructor;
import oracle.alura.challenge.model.CurrencyConversionResponse;
import oracle.alura.challenge.service.strategy.CurrencyConversionStrategy;

@RequiredArgsConstructor
public class CurrencyConversionRepositoryImpl implements CurrencyConversionRepository {
    private final CurrencyConversionStrategy strategy;

    @Override
    public CurrencyConversionResponse getConversionRate(String fromCurrency, String toCurrency, double amount) {
        return strategy.convertCurrency(fromCurrency, toCurrency, amount);
    }
}
