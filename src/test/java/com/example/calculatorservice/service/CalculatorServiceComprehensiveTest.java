package com.example.calculatorservice.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Comprehensive Test Suite for Calculator Service
 *
 * This test class demonstrates:
 * - Multiple test cases for each operation
 * - Edge case testing
 * - Exception handling verification
 * - Clear test naming and organization
 *
 * EASY TO MODIFY: Just copy any test method and change the values!
 */
@DisplayName("Calculator Service - Comprehensive Tests")
public class CalculatorServiceComprehensiveTest {

    private CalculatorService calculator;

    /**
     * BeforeEach runs before EVERY test method
     * Ensures each test starts with a fresh calculator instance
     */
    @BeforeEach
    public void setUp() {
        calculator = new CalculatorService();
    }

    // ========================================
    // ADDITION TESTS
    // ========================================

    @Test
    @DisplayName("Add two positive numbers")
    public void testAdd_PositiveNumbers_ReturnsSum() {
        // Arrange
        int a = 3;
        int b = 5;
        int expected = 8;

        // Act
        int result = calculator.add(a, b);

        // Assert
        assertEquals(expected, result, "3 + 5 should equal 8");
    }

    @Test
    @DisplayName("Add positive and negative number")
    public void testAdd_PositiveAndNegative_ReturnsCorrectSum() {
        // Arrange
        int a = -5;
        int b = 3;
        int expected = -2;

        // Act
        int result = calculator.add(a, b);

        // Assert
        assertEquals(expected, result, "-5 + 3 should equal -2");
    }

    @Test
    @DisplayName("Add two zeros")
    public void testAdd_TwoZeros_ReturnsZero() {
        // Arrange
        int a = 0;
        int b = 0;
        int expected = 0;

        // Act
        int result = calculator.add(a, b);

        // Assert
        assertEquals(expected, result, "0 + 0 should equal 0");
    }

    @Test
    @DisplayName("Add large numbers")
    public void testAdd_LargeNumbers_ReturnsCorrectSum() {
        // Arrange
        int a = 1000000;
        int b = 2000000;
        int expected = 3000000;

        // Act
        int result = calculator.add(a, b);

        // Assert
        assertEquals(expected, result, "Large number addition should work");
    }

    @Test
    @DisplayName("Add numbers that cancel out")
    public void testAdd_OppositeNumbers_ReturnsZero() {
        // Arrange
        int a = 100;
        int b = -100;
        int expected = 0;

        // Act
        int result = calculator.add(a, b);

        // Assert
        assertEquals(expected, result, "100 + (-100) should equal 0");
    }

    // ========================================
    // SUBTRACTION TESTS
    // ========================================

    @Test
    @DisplayName("Subtract two positive numbers")
    public void testSubtract_PositiveNumbers_ReturnsDifference() {
        // Arrange
        int a = 10;
        int b = 4;
        int expected = 6;

        // Act
        int result = calculator.subtract(a, b);

        // Assert
        assertEquals(expected, result, "10 - 4 should equal 6");
    }

    @Test
    @DisplayName("Subtract larger from smaller (negative result)")
    public void testSubtract_LargerFromSmaller_ReturnsNegative() {
        // Arrange
        int a = 5;
        int b = 10;
        int expected = -5;

        // Act
        int result = calculator.subtract(a, b);

        // Assert
        assertEquals(expected, result, "5 - 10 should equal -5");
    }

    @Test
    @DisplayName("Subtract zero from number")
    public void testSubtract_SubtractZero_ReturnsOriginal() {
        // Arrange
        int a = 5;
        int b = 0;
        int expected = 5;

        // Act
        int result = calculator.subtract(a, b);

        // Assert
        assertEquals(expected, result, "5 - 0 should equal 5");
    }

    @Test
    @DisplayName("Subtract from zero")
    public void testSubtract_FromZero_ReturnsNegative() {
        // Arrange
        int a = 0;
        int b = 5;
        int expected = -5;

        // Act
        int result = calculator.subtract(a, b);

        // Assert
        assertEquals(expected, result, "0 - 5 should equal -5");
    }

    @Test
    @DisplayName("Subtract same number")
    public void testSubtract_SameNumber_ReturnsZero() {
        // Arrange
        int a = 42;
        int b = 42;
        int expected = 0;

        // Act
        int result = calculator.subtract(a, b);

        // Assert
        assertEquals(expected, result, "42 - 42 should equal 0");
    }

    @Test
    @DisplayName("Subtract negative number (double negative)")
    public void testSubtract_NegativeNumber_AddsValue() {
        // Arrange
        int a = 10;
        int b = -5;
        int expected = 15;

        // Act
        int result = calculator.subtract(a, b);

        // Assert
        assertEquals(expected, result, "10 - (-5) should equal 15");
    }

    // ========================================
    // MULTIPLICATION TESTS
    // ========================================

    @Test
    @DisplayName("Multiply two positive numbers")
    public void testMultiply_PositiveNumbers_ReturnsProduct() {
        // Arrange
        int a = 6;
        int b = 7;
        int expected = 42;

        // Act
        int result = calculator.multiply(a, b);

        // Assert
        assertEquals(expected, result, "6 * 7 should equal 42");
    }

    @Test
    @DisplayName("Multiply by zero")
    public void testMultiply_ByZero_ReturnsZero() {
        // Arrange
        int a = 5;
        int b = 0;
        int expected = 0;

        // Act
        int result = calculator.multiply(a, b);

        // Assert
        assertEquals(expected, result, "5 * 0 should equal 0");
    }

    @Test
    @DisplayName("Multiply positive and negative")
    public void testMultiply_PositiveAndNegative_ReturnsNegative() {
        // Arrange
        int a = -3;
        int b = 4;
        int expected = -12;

        // Act
        int result = calculator.multiply(a, b);

        // Assert
        assertEquals(expected, result, "-3 * 4 should equal -12");
    }

    @Test
    @DisplayName("Multiply two negative numbers")
    public void testMultiply_TwoNegatives_ReturnsPositive() {
        // Arrange
        int a = -3;
        int b = -4;
        int expected = 12;

        // Act
        int result = calculator.multiply(a, b);

        // Assert
        assertEquals(expected, result, "-3 * -4 should equal 12");
    }

    @Test
    @DisplayName("Multiply by one")
    public void testMultiply_ByOne_ReturnsSameNumber() {
        // Arrange
        int a = 42;
        int b = 1;
        int expected = 42;

        // Act
        int result = calculator.multiply(a, b);

        // Assert
        assertEquals(expected, result, "42 * 1 should equal 42");
    }

    @Test
    @DisplayName("Multiply large numbers")
    public void testMultiply_LargeNumbers_ReturnsCorrectProduct() {
        // Arrange
        int a = 1000;
        int b = 500;
        int expected = 500000;

        // Act
        int result = calculator.multiply(a, b);

        // Assert
        assertEquals(expected, result, "1000 * 500 should equal 500000");
    }

    // ========================================
    // DIVISION TESTS - HAPPY PATH
    // ========================================

    @Test
    @DisplayName("Divide evenly")
    public void testDivide_EvenDivision_ReturnsQuotient() {
        // Arrange
        int a = 20;
        int b = 4;
        int expected = 5;

        // Act
        int result = calculator.divide(a, b);

        // Assert
        assertEquals(expected, result, "20 / 4 should equal 5");
    }

    @Test
    @DisplayName("Divide with remainder (integer division)")
    public void testDivide_WithRemainder_ReturnsTruncatedQuotient() {
        // Arrange
        int a = 10;
        int b = 3;
        int expected = 3; // Integer division truncates

        // Act
        int result = calculator.divide(a, b);

        // Assert
        assertEquals(expected, result, "10 / 3 should equal 3 (integer division)");
    }

    @Test
    @DisplayName("Divide zero by number")
    public void testDivide_ZeroDividend_ReturnsZero() {
        // Arrange
        int a = 0;
        int b = 5;
        int expected = 0;

        // Act
        int result = calculator.divide(a, b);

        // Assert
        assertEquals(expected, result, "0 / 5 should equal 0");
    }

    @Test
    @DisplayName("Divide negative by positive")
    public void testDivide_NegativeByPositive_ReturnsNegative() {
        // Arrange
        int a = -20;
        int b = 4;
        int expected = -5;

        // Act
        int result = calculator.divide(a, b);

        // Assert
        assertEquals(expected, result, "-20 / 4 should equal -5");
    }

    @Test
    @DisplayName("Divide two negatives")
    public void testDivide_TwoNegatives_ReturnsPositive() {
        // Arrange
        int a = -20;
        int b = -4;
        int expected = 5;

        // Act
        int result = calculator.divide(a, b);

        // Assert
        assertEquals(expected, result, "-20 / -4 should equal 5");
    }

    @Test
    @DisplayName("Divide by one")
    public void testDivide_ByOne_ReturnsSameNumber() {
        // Arrange
        int a = 42;
        int b = 1;
        int expected = 42;

        // Act
        int result = calculator.divide(a, b);

        // Assert
        assertEquals(expected, result, "42 / 1 should equal 42");
    }

    @Test
    @DisplayName("Divide number by itself")
    public void testDivide_ByItself_ReturnsOne() {
        // Arrange
        int a = 42;
        int b = 42;
        int expected = 1;

        // Act
        int result = calculator.divide(a, b);

        // Assert
        assertEquals(expected, result, "42 / 42 should equal 1");
    }

    // ========================================
    // DIVISION TESTS - EXCEPTION HANDLING
    // ========================================

    @Test
    @DisplayName("Divide by zero throws IllegalArgumentException")
    public void testDivide_ByZero_ThrowsIllegalArgumentException() {
        // Arrange
        int a = 10;
        int b = 0;

        // Act & Assert
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> calculator.divide(a, b),
            "Division by zero should throw IllegalArgumentException"
        );

        // Verify exception message
        assertEquals("Cannot divide by zero", exception.getMessage(),
            "Exception message should be 'Cannot divide by zero'");
    }

    @Test
    @DisplayName("Divide zero by zero throws IllegalArgumentException")
    public void testDivide_ZeroByZero_ThrowsIllegalArgumentException() {
        // Arrange
        int a = 0;
        int b = 0;

        // Act & Assert
        assertThrows(
            IllegalArgumentException.class,
            () -> calculator.divide(a, b),
            "0 / 0 should throw IllegalArgumentException"
        );
    }

    @Test
    @DisplayName("Divide negative by zero throws IllegalArgumentException")
    public void testDivide_NegativeByZero_ThrowsIllegalArgumentException() {
        // Arrange
        int a = -10;
        int b = 0;

        // Act & Assert
        assertThrows(
            IllegalArgumentException.class,
            () -> calculator.divide(a, b),
            "Division of negative number by zero should throw IllegalArgumentException"
        );
    }
}
