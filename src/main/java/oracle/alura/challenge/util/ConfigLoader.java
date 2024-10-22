package oracle.alura.challenge.util;


import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class ConfigLoader {
    private static final Properties properties = new Properties();

    static {
        loadProperties("application.properties");
    }

    /**
     * Carga un archivo de propiedades dado.
     *
     * @param fileName Nombre del archivo de propiedades.
     */
    private static void loadProperties(String fileName) {
        try (InputStream input = ConfigLoader.class.getClassLoader().getResourceAsStream(fileName)) {
            if (input == null) {
                throw new IOException("No se pudo encontrar el archivo de propiedades: " + fileName);
            }
            properties.load(new java.io.InputStreamReader(input, StandardCharsets.UTF_8));
        } catch (IOException e) {
            System.err.println("Error al cargar el archivo de propiedades: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Obtiene el valor de una propiedad.
     *
     * @param key          Clave de la propiedad.
     * @param defaultValue Valor por defecto si la clave no existe.
     * @return El valor de la propiedad o el valor por defecto si no se encuentra.
     */
    public static String getProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }

    /**
     * Obtiene el valor de una propiedad.
     *
     * @param key Clave de la propiedad.
     * @return El valor de la propiedad o null si no se encuentra.
     */
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    /**
     * Recarga el archivo de propiedades.
     */
    public static void reload() {
        properties.clear();
        loadProperties("application.properties");
    }

    /**
     * Carga un archivo de propiedades específico.
     *
     * @param fileName Nombre del archivo de propiedades a cargar.
     */
    public static void loadAdditionalProperties(String fileName) {
        loadProperties(fileName);
    }
}
