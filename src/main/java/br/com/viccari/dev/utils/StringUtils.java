package br.com.viccari.dev.utils;

public class StringUtils {
    
    private StringUtils(){}

    public static final boolean isEmpty(String value) {
        return value == null 
            || value.isEmpty() 
            || value.isBlank();
    }
}
