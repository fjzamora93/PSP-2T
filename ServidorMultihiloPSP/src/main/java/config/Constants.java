package config;

public class Constants {
    public static final String IP_SERVIDOR = "192.168.1.156";
    public static final int PORT = 2001;
    public static final String BASE_URL = "http://www.omdbapi.com/";
    public static final String API_KEY = "f9c39ba3";

    // Constructor privado para evitar instanciación
    private Constants() {
        throw new UnsupportedOperationException("Esta es una clase de constantes y no debe ser instanciada");
    }
}
