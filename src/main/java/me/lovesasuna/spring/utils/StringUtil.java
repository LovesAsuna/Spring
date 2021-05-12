package me.lovesasuna.spring.utils;

/**
 * @author LovesAsuna
 **/
public class StringUtil {
    private StringUtil() {

    }

    public static String getSetterMethodByFieldName(String fieldName) {
        return "set" + fieldName.substring(0, 1).toUpperCase()  + fieldName.substring(1);
    }
}
