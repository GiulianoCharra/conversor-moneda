package oracle.alura.challenge.service;

import oracle.alura.challenge.model.CurrencyConversionResponse;

public interface CurrencyConversionService {
    CurrencyConversionResponse convertCurrency(String fromCurrency, String toCurrency, double amount);
}
