package oracle.alura.challenge.service.strategy;

import oracle.alura.challenge.model.CurrencyConversionResponse;

public interface CurrencyConversionStrategy {
    CurrencyConversionResponse convertCurrency(String fromCurrency, String toCurrency, double amount);
}
