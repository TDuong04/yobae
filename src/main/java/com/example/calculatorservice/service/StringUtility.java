package com.example.calculatorservice.service;

import org.springframework.stereotype.Service;

/**
 * String Utility Service
 *
 * Provides basic string manipulation operations.
 * All methods are stateless and thread-safe.
 */
@Service
public class StringUtility {

    /**
     * Concatenates two strings together.
     *
     * @param a First string
     * @param b Second string
     * @return Concatenated result (a + b)
     */
    public String concatenate(String a, String b) {
        return a + b;
    }

    /**
     * Reverses a string.
     *
     * @param s String to reverse
     * @return Reversed string
     */
    public String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    /**
     * Converts a string to uppercase.
     *
     * @param s String to convert
     * @return Uppercase version of the string
     */
    public String toUpperCase(String s) {
        return s.toUpperCase();
    }

    /**
     * Gets the length of a string.
     *
     * @param s String to measure
     * @return Length of the string
     * @throws IllegalArgumentException if string is null
     */
    public int getLength(String s) {
        if (s == null) {
            throw new IllegalArgumentException("String cannot be null");
        }
        return s.length();
    }
}
