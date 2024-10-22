package oracle.alura.challenge;


import oracle.alura.challenge.controller.CurrencyConversionController;
import oracle.alura.challenge.factory.CurrencyConversionServiceFactory;
import oracle.alura.challenge.model.CurrencyConversionResponse;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CurrencyConversionController controller = new CurrencyConversionController(CurrencyConversionServiceFactory.createCurrencyService());
        Scanner scanner = new Scanner(System.in);
        int opcion;

        // Lista para almacenar el historial de conversiones
        List<String> conversionHistory = new ArrayList<>();

        do {
            System.out.println("¡Bienvenido al conversor de monedas!");
            System.out.println("Selecciona una opción:");
            System.out.println("1. Dólar a Peso Argentino");
            System.out.println("2. Peso Argentino a Dólar");
            System.out.println("3. Dólar a Real Brasileño");
            System.out.println("4. Real Brasileño a Dólar");
            System.out.println("5. Euro a Dólar");
            System.out.println("6. Ver historial de conversiones");
            System.out.println("7. Salir");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();

            if (opcion >= 1 && opcion <= 5) {
                System.out.print("Ingrese la cantidad a convertir: ");
                double amount = scanner.nextDouble();
                String fromCurrency = "";
                String toCurrency = "";

                switch (opcion) {
                    case 1 -> {
                        fromCurrency = "USD";
                        toCurrency = "ARS";
                    }
                    case 2 -> {
                        fromCurrency = "ARS";
                        toCurrency = "USD";
                    }
                    case 3 -> {
                        fromCurrency = "USD";
                        toCurrency = "BRL";
                    }
                    case 4 -> {
                        fromCurrency = "BRL";
                        toCurrency = "USD";
                    }
                    case 5 -> {
                        fromCurrency = "EUR";
                        toCurrency = "USD";
                    }
                }

                // Realizar la conversión
                CurrencyConversionResponse response = controller.convertCurrency(fromCurrency, toCurrency, amount);
                double resultado = response.getConversionResult();
                System.out.println("El valor convertido es: " + resultado + "\n");

                // Registrar la conversión en el historial
                String conversionRecord = String.format("Fecha: %s | De: %s a %s | Cantidad: %.2f | Resultado: %.2f",
                                                        LocalDateTime.now(), fromCurrency, toCurrency, amount, resultado);
                conversionHistory.add(conversionRecord);

            } else if (opcion == 6) {
                // Mostrar el historial de conversiones
                if (conversionHistory.isEmpty()) {
                    System.out.println("No hay conversiones realizadas.\n");
                } else {
                    System.out.println("Historial de Conversiones:");
                    conversionHistory.forEach(System.out::println);
                    System.out.println();
                }
            } else if (opcion == 7) {
                System.out.println("Gracias por usar el conversor de monedas. ¡Adiós!");
            } else {
                System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        } while (opcion != 7);

        scanner.close();
    }
}

