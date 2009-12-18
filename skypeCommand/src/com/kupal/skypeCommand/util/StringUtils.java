package com.kupal.skypeCommand.util;

/**
 * Siarhei.Krauchenia
 * 16.12.2009
 */
public class StringUtils {

    public static boolean isEmpty(String token) {
        return token == null || "".equals(token);
    }

    public static boolean isNotEmpty(String token) {
        return !isEmpty(token);
    }
}
