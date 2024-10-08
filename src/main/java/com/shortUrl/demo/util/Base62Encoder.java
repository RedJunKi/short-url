package com.shortUrl.demo.util;

public class Base62Encoder {

    private static final String CHARACTERS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int BASE = CHARACTERS.length();

    public static String encode(Long num) {
        StringBuilder encoded = new StringBuilder();

        while (num > 0) {
            int remainder = (int) (num % BASE);
            encoded.insert(0, CHARACTERS.charAt(remainder));
            num /= BASE;
        }

        if (encoded.length() == 0) {
            return "0000000";
        }

        while (encoded.length() < 7) {
            encoded.insert(0, '0');
        }

        return encoded.toString();
    }
}
