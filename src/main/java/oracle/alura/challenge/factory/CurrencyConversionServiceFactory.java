package oracle.alura.challenge.factory;

import oracle.alura.challenge.repository.CurrencyConversionRepository;
import oracle.alura.challenge.repository.CurrencyConversionRepositoryImpl;
import oracle.alura.challenge.service.CurrencyConversionService;
import oracle.alura.challenge.service.CurrencyConversionServiceImpl;
import oracle.alura.challenge.service.strategy.ExchangeRateApiStrategy;

public class CurrencyConversionServiceFactory {
    public static CurrencyConversionService createCurrencyService() {
        // Crear la estrategia de conversión
        ExchangeRateApiStrategy strategy = new ExchangeRateApiStrategy();
        // Crear el repositorio utilizando la estrategia
        CurrencyConversionRepository repository = new CurrencyConversionRepositoryImpl(strategy);
        // Crear el servicio utilizando el repositorio
        return new CurrencyConversionServiceImpl(repository);
    }
}
