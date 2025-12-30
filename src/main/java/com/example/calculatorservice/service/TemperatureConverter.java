package com.example.calculatorservice.service;

import org.springframework.stereotype.Service;

/**
 * Temperature Converter Service
 *
 * Provides temperature conversion between different scales.
 * All methods are stateless and thread-safe.
 */
@Service
public class TemperatureConverter {

    /**
     * Converts Celsius to Fahrenheit.
     * Formula: F = (C × 9/5) + 32
     *
     * @param celsius Temperature in Celsius
     * @return Temperature in Fahrenheit
     */
    public double celsiusToFahrenheit(double celsius) {
        return (celsius * 9.0 / 5.0) + 32.0;
    }

    /**
     * Converts Fahrenheit to Celsius.
     * Formula: C = (F - 32) × 5/9
     *
     * @param fahrenheit Temperature in Fahrenheit
     * @return Temperature in Celsius
     */
    public double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32.0) * 5.0 / 9.0;
    }

    /**
     * Checks if a Celsius temperature is valid (above absolute zero).
     * Absolute zero is -273.15°C
     *
     * @param celsius Temperature in Celsius to validate
     * @return true if temperature is at or above absolute zero, false otherwise
     */
    public boolean isValidCelsius(double celsius) {
        return celsius >= -273.15;
    }

    /**
     * Converts Kelvin to Celsius.
     * Formula: C = K - 273.15
     *
     * @param kelvin Temperature in Kelvin
     * @return Temperature in Celsius
     * @throws IllegalArgumentException if kelvin is negative
     */
    public double kelvinToCelsius(double kelvin) {
        if (kelvin < 0) {
            throw new IllegalArgumentException("Kelvin cannot be negative");
        }
        return kelvin - 273.15;
    }
}
