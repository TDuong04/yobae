package com.example.calculatorservice.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Comprehensive test suite for DrinkVolumeConverter service.
 *
 * Test Strategy:
 * - Test standard drink volumes (common cup/mL values)
 * - Test the exact conversion rate (250 mL = 1 cup)
 * - Test fractional values (half cups, partial mL)
 * - Test edge cases (zero, large volumes)
 * - Test error handling (negative values)
 * - Use 0.01 tolerance for floating-point comparisons
 *
 * Real-world context: Volumes are based on typical drink measurements
 * used in cafes and home baking.
 */
@DisplayName("Drink Volume Converter Tests")
public class DrinkVolumeConverterTest {

    private DrinkVolumeConverter converter;

    @BeforeEach
    public void setUp() {
        converter = new DrinkVolumeConverter();
    }

    // ========================================
    // MILLILITRES TO CUPS TESTS
    // ========================================

    @Test
    @DisplayName("Convert 500mL to 2 cups")
    public void testMillilitresToCups_StandardVolume() {
        // Arrange
        double millilitres = 500.0;
        double expected = 2.0;

        // Act
        double result = converter.millilitresToCups(millilitres);

        // Assert
        assertEquals(expected, result, 0.01,
            "500 mL should convert to 2 cups (standard drink volume)");
    }

    @Test
    @DisplayName("Convert 250mL to 1 cup (exact conversion)")
    public void testMillilitresToCups_ExactConversion() {
        // Arrange
        double millilitres = 250.0;
        double expected = 1.0;

        // Act
        double result = converter.millilitresToCups(millilitres);

        // Assert
        assertEquals(expected, result, 0.01,
            "250 mL should convert to exactly 1 cup (conversion rate)");
    }

    @Test
    @DisplayName("Convert 100mL to 0.4 cups")
    public void testMillilitresToCups_FractionalResult() {
        // Arrange
        double millilitres = 100.0;
        double expected = 0.4;

        // Act
        double result = converter.millilitresToCups(millilitres);

        // Assert
        assertEquals(expected, result, 0.01,
            "100 mL should convert to 0.4 cups (fractional result)");
    }

    @Test
    @DisplayName("Convert 0mL to 0 cups")
    public void testMillilitresToCups_ZeroVolume() {
        // Arrange
        double millilitres = 0.0;
        double expected = 0.0;

        // Act
        double result = converter.millilitresToCups(millilitres);

        // Assert
        assertEquals(expected, result, 0.01,
            "0 mL should convert to 0 cups (zero edge case)");
    }

    @Test
    @DisplayName("Convert 1000mL to 4 cups")
    public void testMillilitresToCups_LargeVolume() {
        // Arrange
        double millilitres = 1000.0;
        double expected = 4.0;

        // Act
        double result = converter.millilitresToCups(millilitres);

        // Assert
        assertEquals(expected, result, 0.01,
            "1000 mL (1 litre) should convert to 4 cups (large volume)");
    }

    @Test
    @DisplayName("Convert 125mL to 0.5 cups")
    public void testMillilitresToCups_SmallVolume() {
        // Arrange
        double millilitres = 125.0;
        double expected = 0.5;

        // Act
        double result = converter.millilitresToCups(millilitres);

        // Assert
        assertEquals(expected, result, 0.01,
            "125 mL should convert to 0.5 cups (half cup measurement)");
    }

    @Test
    @DisplayName("Negative mL throws exception")
    public void testMillilitresToCups_NegativeValue_ThrowsException() {
        // Arrange
        double millilitres = -100.0;

        // Act & Assert
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> converter.millilitresToCups(millilitres),
            "Negative millilitres should throw IllegalArgumentException"
        );

        // Verify exception message
        assertEquals("Volume cannot be negative", exception.getMessage(),
            "Exception message should be 'Volume cannot be negative'");
    }

    // ========================================
    // CUPS TO MILLILITRES TESTS
    // ========================================

    @Test
    @DisplayName("Convert 2 cups to 500mL")
    public void testCupsToMillilitres_StandardVolume() {
        // Arrange
        double cups = 2.0;
        double expected = 500.0;

        // Act
        double result = converter.cupsToMillilitres(cups);

        // Assert
        assertEquals(expected, result, 0.01,
            "2 cups should convert to 500 mL (standard drink volume)");
    }

    @Test
    @DisplayName("Convert 1 cup to 250mL (exact conversion)")
    public void testCupsToMillilitres_ExactConversion() {
        // Arrange
        double cups = 1.0;
        double expected = 250.0;

        // Act
        double result = converter.cupsToMillilitres(cups);

        // Assert
        assertEquals(expected, result, 0.01,
            "1 cup should convert to exactly 250 mL (conversion rate)");
    }

    @Test
    @DisplayName("Convert 0.5 cups to 125mL")
    public void testCupsToMillilitres_HalfCup() {
        // Arrange
        double cups = 0.5;
        double expected = 125.0;

        // Act
        double result = converter.cupsToMillilitres(cups);

        // Assert
        assertEquals(expected, result, 0.01,
            "0.5 cups (half cup) should convert to 125 mL");
    }

    @Test
    @DisplayName("Convert 0 cups to 0mL")
    public void testCupsToMillilitres_ZeroVolume() {
        // Arrange
        double cups = 0.0;
        double expected = 0.0;

        // Act
        double result = converter.cupsToMillilitres(cups);

        // Assert
        assertEquals(expected, result, 0.01,
            "0 cups should convert to 0 mL (zero edge case)");
    }

    @Test
    @DisplayName("Convert 4 cups to 1000mL")
    public void testCupsToMillilitres_LargeVolume() {
        // Arrange
        double cups = 4.0;
        double expected = 1000.0;

        // Act
        double result = converter.cupsToMillilitres(cups);

        // Assert
        assertEquals(expected, result, 0.01,
            "4 cups should convert to 1000 mL (1 litre, large volume)");
    }

    @Test
    @DisplayName("Convert 1.5 cups to 375mL")
    public void testCupsToMillilitres_DecimalCups() {
        // Arrange
        double cups = 1.5;
        double expected = 375.0;

        // Act
        double result = converter.cupsToMillilitres(cups);

        // Assert
        assertEquals(expected, result, 0.01,
            "1.5 cups should convert to 375 mL (decimal cup measurement)");
    }

    @Test
    @DisplayName("Convert 0.25 cups to 62.5mL")
    public void testCupsToMillilitres_QuarterCup() {
        // Arrange
        double cups = 0.25;
        double expected = 62.5;

        // Act
        double result = converter.cupsToMillilitres(cups);

        // Assert
        assertEquals(expected, result, 0.01,
            "0.25 cups (quarter cup) should convert to 62.5 mL");
    }

    @Test
    @DisplayName("Negative cups throws exception")
    public void testCupsToMillilitres_NegativeValue_ThrowsException() {
        // Arrange
        double cups = -2.0;

        // Act & Assert
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> converter.cupsToMillilitres(cups),
            "Negative cups should throw IllegalArgumentException"
        );

        // Verify exception message
        assertEquals("Volume cannot be negative", exception.getMessage(),
            "Exception message should be 'Volume cannot be negative'");
    }
}
