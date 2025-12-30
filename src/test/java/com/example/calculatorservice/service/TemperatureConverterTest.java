package com.example.calculatorservice.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Comprehensive test suite for TemperatureConverter service.
 *
 * Test Strategy:
 * - Test common temperature conversions (freezing, boiling, body temp)
 * - Test edge cases (absolute zero, same value in different scales)
 * - Test validation logic for absolute zero
 * - Test exception handling for invalid Kelvin values
 */
@DisplayName("Temperature Converter Service Tests")
public class TemperatureConverterTest {

    private TemperatureConverter converter;

    @BeforeEach
    public void setUp() {
        converter = new TemperatureConverter();
    }

    // ========================================
    // CELSIUS TO FAHRENHEIT TESTS
    // ========================================

    @Test
    @DisplayName("Convert freezing point (0°C to 32°F)")
    public void testCelsiusToFahrenheit_FreezingPoint() {
        // Arrange
        double celsius = 0.0;
        double expected = 32.0;

        // Act
        double result = converter.celsiusToFahrenheit(celsius);

        // Assert
        assertEquals(expected, result, 0.01,
            "0°C should convert to 32°F (water freezing point)");
    }

    @Test
    @DisplayName("Convert boiling point (100°C to 212°F)")
    public void testCelsiusToFahrenheit_BoilingPoint() {
        // Arrange
        double celsius = 100.0;
        double expected = 212.0;

        // Act
        double result = converter.celsiusToFahrenheit(celsius);

        // Assert
        assertEquals(expected, result, 0.01,
            "100°C should convert to 212°F (water boiling point)");
    }

    @Test
    @DisplayName("Convert body temperature (37°C to 98.6°F)")
    public void testCelsiusToFahrenheit_BodyTemperature() {
        // Arrange
        double celsius = 37.0;
        double expected = 98.6;

        // Act
        double result = converter.celsiusToFahrenheit(celsius);

        // Assert
        assertEquals(expected, result, 0.01,
            "37°C should convert to 98.6°F (normal body temperature)");
    }

    @Test
    @DisplayName("Convert same value point (-40°C to -40°F)")
    public void testCelsiusToFahrenheit_SameValue() {
        // Arrange
        double celsius = -40.0;
        double expected = -40.0;

        // Act
        double result = converter.celsiusToFahrenheit(celsius);

        // Assert
        assertEquals(expected, result, 0.01,
            "-40°C should convert to -40°F (where scales meet)");
    }

    // ========================================
    // FAHRENHEIT TO CELSIUS TESTS
    // ========================================

    @Test
    @DisplayName("Convert freezing point (32°F to 0°C)")
    public void testFahrenheitToCelsius_FreezingPoint() {
        // Arrange
        double fahrenheit = 32.0;
        double expected = 0.0;

        // Act
        double result = converter.fahrenheitToCelsius(fahrenheit);

        // Assert
        assertEquals(expected, result, 0.01,
            "32°F should convert to 0°C (water freezing point)");
    }

    @Test
    @DisplayName("Convert boiling point (212°F to 100°C)")
    public void testFahrenheitToCelsius_BoilingPoint() {
        // Arrange
        double fahrenheit = 212.0;
        double expected = 100.0;

        // Act
        double result = converter.fahrenheitToCelsius(fahrenheit);

        // Assert
        assertEquals(expected, result, 0.01,
            "212°F should convert to 100°C (water boiling point)");
    }

    @Test
    @DisplayName("Convert body temperature (98.6°F to 37°C)")
    public void testFahrenheitToCelsius_BodyTemperature() {
        // Arrange
        double fahrenheit = 98.6;
        double expected = 37.0;

        // Act
        double result = converter.fahrenheitToCelsius(fahrenheit);

        // Assert
        assertEquals(expected, result, 0.01,
            "98.6°F should convert to 37°C (normal body temperature)");
    }

    @Test
    @DisplayName("Convert same value point (-40°F to -40°C)")
    public void testFahrenheitToCelsius_SameValue() {
        // Arrange
        double fahrenheit = -40.0;
        double expected = -40.0;

        // Act
        double result = converter.fahrenheitToCelsius(fahrenheit);

        // Assert
        assertEquals(expected, result, 0.01,
            "-40°F should convert to -40°C (where scales meet)");
    }

    // ========================================
    // IS VALID CELSIUS TESTS
    // ========================================

    @Test
    @DisplayName("Room temperature is valid (20°C)")
    public void testIsValidCelsius_RoomTemperature() {
        // Arrange
        double celsius = 20.0;

        // Act
        boolean result = converter.isValidCelsius(celsius);

        // Assert
        assertTrue(result,
            "Room temperature (20°C) should be valid");
    }

    @Test
    @DisplayName("Absolute zero is valid (-273.15°C)")
    public void testIsValidCelsius_AbsoluteZero() {
        // Arrange
        double celsius = -273.15;

        // Act
        boolean result = converter.isValidCelsius(celsius);

        // Assert
        assertTrue(result,
            "Absolute zero (-273.15°C) should be valid (boundary)");
    }

    @Test
    @DisplayName("Below absolute zero is invalid (-300°C)")
    public void testIsValidCelsius_BelowAbsoluteZero() {
        // Arrange
        double celsius = -300.0;

        // Act
        boolean result = converter.isValidCelsius(celsius);

        // Assert
        assertFalse(result,
            "Temperature below absolute zero (-300°C) should be invalid");
    }

    @Test
    @DisplayName("High temperature is valid (1000°C)")
    public void testIsValidCelsius_HighTemperature() {
        // Arrange
        double celsius = 1000.0;

        // Act
        boolean result = converter.isValidCelsius(celsius);

        // Assert
        assertTrue(result,
            "High temperature (1000°C) should be valid");
    }

    // ========================================
    // KELVIN TO CELSIUS TESTS
    // ========================================

    @Test
    @DisplayName("Convert water freezing point (273.15K to 0°C)")
    public void testKelvinToCelsius_FreezingPoint() {
        // Arrange
        double kelvin = 273.15;
        double expected = 0.0;

        // Act
        double result = converter.kelvinToCelsius(kelvin);

        // Assert
        assertEquals(expected, result, 0.01,
            "273.15K should convert to 0°C (water freezing point)");
    }

    @Test
    @DisplayName("Convert water boiling point (373.15K to 100°C)")
    public void testKelvinToCelsius_BoilingPoint() {
        // Arrange
        double kelvin = 373.15;
        double expected = 100.0;

        // Act
        double result = converter.kelvinToCelsius(kelvin);

        // Assert
        assertEquals(expected, result, 0.01,
            "373.15K should convert to 100°C (water boiling point)");
    }

    @Test
    @DisplayName("Convert absolute zero (0K to -273.15°C)")
    public void testKelvinToCelsius_AbsoluteZero() {
        // Arrange
        double kelvin = 0.0;
        double expected = -273.15;

        // Act
        double result = converter.kelvinToCelsius(kelvin);

        // Assert
        assertEquals(expected, result, 0.01,
            "0K should convert to -273.15°C (absolute zero)");
    }

    @Test
    @DisplayName("Negative Kelvin throws exception")
    public void testKelvinToCelsius_NegativeKelvin_ThrowsException() {
        // Arrange
        double kelvin = -10.0;

        // Act & Assert
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> converter.kelvinToCelsius(kelvin),
            "Negative Kelvin temperature should throw IllegalArgumentException"
        );

        // Verify exception message
        assertEquals("Kelvin cannot be negative", exception.getMessage(),
            "Exception message should be 'Kelvin cannot be negative'");
    }

    @Test
    @DisplayName("Room temperature Kelvin (293.15K to 20°C)")
    public void testKelvinToCelsius_RoomTemperature() {
        // Arrange
        double kelvin = 293.15;
        double expected = 20.0;

        // Act
        double result = converter.kelvinToCelsius(kelvin);

        // Assert
        assertEquals(expected, result, 0.01,
            "293.15K should convert to 20°C (room temperature)");
    }
}
