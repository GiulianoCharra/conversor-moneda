package oracle.alura.challenge.service.strategy;

import com.google.gson.Gson;
import oracle.alura.challenge.model.CurrencyConversionResponse;
import oracle.alura.challenge.util.ConfigLoader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public class ExchangeRateApiStrategy implements CurrencyConversionStrategy {
    private static final String API_KEY = ConfigLoader.getProperty("EXCHANGE_RATE_API_KEY");
    private static final String BASE_URL = ConfigLoader.getProperty("EXCHANGE_RATE_API_BASE_URL");

    @Override
    public CurrencyConversionResponse convertCurrency(String fromCurrency, String toCurrency, double amount) {
        String formattedAmount = String.format("%.4f", amount).replace(",", ".");
        String urlString = String.format("%s%s/pair/%s/%s/%s", BASE_URL, API_KEY, fromCurrency, toCurrency, formattedAmount);
        try {
            URL url = URI.create(urlString).toURL();
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            if (connection.getResponseCode() != 200) {
                throw new RuntimeException("Failed to connect: HTTP error code : " + connection.getResponseCode());
            }

            // Usar Gson para parsear la respuesta JSON
            InputStreamReader reader = new InputStreamReader(connection.getInputStream());
            Gson gson = new Gson();
            CurrencyConversionResponse response = gson.fromJson(reader, CurrencyConversionResponse.class);
            reader.close();
            return response;
        } catch (IOException e) {
            e.printStackTrace();
            CurrencyConversionResponse errorResponse = new CurrencyConversionResponse();
            errorResponse.setResult("error");
            errorResponse.setErrorType("connection-failure");
            return errorResponse;
        }
    }
}
