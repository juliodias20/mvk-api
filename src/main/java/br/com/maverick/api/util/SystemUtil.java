package br.com.maverick.api.util;

public class SystemUtil {

    public static String getEnv(String variable) {
        String result = System.getProperty(variable);
        if (result == null) {
            result = System.getenv(variable);
        }
        return result;
    }

}
