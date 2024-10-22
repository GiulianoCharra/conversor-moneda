package oracle.alura.challenge.repository;

import oracle.alura.challenge.model.CurrencyConversionResponse;

public interface CurrencyConversionRepository {
    CurrencyConversionResponse getConversionRate(String fromCurrency, String toCurrency, double amount);
}
