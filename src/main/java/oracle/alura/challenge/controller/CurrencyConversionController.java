package oracle.alura.challenge.controller;

import lombok.RequiredArgsConstructor;
import oracle.alura.challenge.model.CurrencyConversionResponse;
import oracle.alura.challenge.service.CurrencyConversionService;

@RequiredArgsConstructor
public class CurrencyConversionController {
    private final CurrencyConversionService currencyConversionService;

    public CurrencyConversionResponse convertCurrency(String fromCurrency, String toCurrency, double amount) {
        return currencyConversionService.convertCurrency(fromCurrency, toCurrency, amount);
    }
}