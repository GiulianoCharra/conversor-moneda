package oracle.alura.challenge.service.strategy;

import oracle.alura.challenge.model.CurrencyConversionResponse;

public class AnotherApiStrategy implements CurrencyConversionStrategy {


    @Override
    public CurrencyConversionResponse convertCurrency(
            String fromCurrency,
            String toCurrency,
            double amount) {
        CurrencyConversionResponse response = new CurrencyConversionResponse();

        response.setResult("success");
        response.setBaseCode(fromCurrency);
        response.setTargetCode(toCurrency);
        response.setConversionRate(0.5);
        response.setConversionResult(amount * response.getConversionRate());

        return response;
    }
}
