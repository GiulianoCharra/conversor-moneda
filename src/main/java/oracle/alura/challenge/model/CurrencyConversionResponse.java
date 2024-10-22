package oracle.alura.challenge.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class CurrencyConversionResponse {
    private String result;

    @SerializedName("base_code")
    private String baseCode;

    @SerializedName("target_code")
    private String targetCode;

    @SerializedName("conversion_rate")
    private double conversionRate;

    @SerializedName("conversion_result")
    private Double conversionResult; // Puede ser nulo si no se proporciona un monto

    private String errorType;
}
