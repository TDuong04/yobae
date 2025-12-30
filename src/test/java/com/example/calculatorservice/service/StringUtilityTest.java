package com.example.calculatorservice.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Comprehensive test suite for StringUtility service.
 *
 * Test Strategy:
 * - Each operation has multiple test cases covering different scenarios
 * - Edge cases (empty strings, single chars) are tested
 * - Exception handling is verified
 * - Test values are chosen to be simple, clear, and representative
 */
@DisplayName("String Utility Service Tests")
public class StringUtilityTest {

    private StringUtility stringUtil;

    @BeforeEach
    public void setUp() {
        stringUtil = new StringUtility();
    }

    // ========================================
    // CONCATENATE TESTS
    // ========================================

    @Test
    @DisplayName("Concatenate two normal strings")
    public void testConcatenate_TwoNormalStrings() {
        // Arrange
        String a = "Hello";
        String b = "World";
        String expected = "HelloWorld";

        // Act
        String result = stringUtil.concatenate(a, b);

        // Assert
        assertEquals(expected, result,
            "Concatenating 'Hello' and 'World' should produce 'HelloWorld'");
    }

    @Test
    @DisplayName("Concatenate with first string empty")
    public void testConcatenate_FirstStringEmpty() {
        // Arrange
        String a = "";
        String b = "Hello";
        String expected = "Hello";

        // Act
        String result = stringUtil.concatenate(a, b);

        // Assert
        assertEquals(expected, result,
            "Concatenating empty string with 'Hello' should produce 'Hello'");
    }

    @Test
    @DisplayName("Concatenate with second string empty")
    public void testConcatenate_SecondStringEmpty() {
        // Arrange
        String a = "Hello";
        String b = "";
        String expected = "Hello";

        // Act
        String result = stringUtil.concatenate(a, b);

        // Assert
        assertEquals(expected, result,
            "Concatenating 'Hello' with empty string should produce 'Hello'");
    }

    @Test
    @DisplayName("Concatenate two empty strings")
    public void testConcatenate_BothEmpty() {
        // Arrange
        String a = "";
        String b = "";
        String expected = "";

        // Act
        String result = stringUtil.concatenate(a, b);

        // Assert
        assertEquals(expected, result,
            "Concatenating two empty strings should produce empty string");
    }

    // ========================================
    // REVERSE TESTS
    // ========================================

    @Test
    @DisplayName("Reverse a normal string")
    public void testReverse_NormalString() {
        // Arrange
        String input = "Hello";
        String expected = "olleH";

        // Act
        String result = stringUtil.reverse(input);

        // Assert
        assertEquals(expected, result,
            "Reversing 'Hello' should produce 'olleH'");
    }

    @Test
    @DisplayName("Reverse an empty string")
    public void testReverse_EmptyString() {
        // Arrange
        String input = "";
        String expected = "";

        // Act
        String result = stringUtil.reverse(input);

        // Assert
        assertEquals(expected, result,
            "Reversing empty string should produce empty string");
    }

    @Test
    @DisplayName("Reverse a single character")
    public void testReverse_SingleCharacter() {
        // Arrange
        String input = "A";
        String expected = "A";

        // Act
        String result = stringUtil.reverse(input);

        // Assert
        assertEquals(expected, result,
            "Reversing single character should return the same character");
    }

    @Test
    @DisplayName("Reverse a palindrome")
    public void testReverse_Palindrome() {
        // Arrange
        String input = "racecar";
        String expected = "racecar";

        // Act
        String result = stringUtil.reverse(input);

        // Assert
        assertEquals(expected, result,
            "Reversing palindrome should produce the same string");
    }

    // ========================================
    // TO UPPERCASE TESTS
    // ========================================

    @Test
    @DisplayName("Convert lowercase to uppercase")
    public void testToUpperCase_AllLowercase() {
        // Arrange
        String input = "hello";
        String expected = "HELLO";

        // Act
        String result = stringUtil.toUpperCase(input);

        // Assert
        assertEquals(expected, result,
            "Converting 'hello' to uppercase should produce 'HELLO'");
    }

    @Test
    @DisplayName("Convert already uppercase string")
    public void testToUpperCase_AlreadyUppercase() {
        // Arrange
        String input = "HELLO";
        String expected = "HELLO";

        // Act
        String result = stringUtil.toUpperCase(input);

        // Assert
        assertEquals(expected, result,
            "Converting already uppercase string should return same string");
    }

    @Test
    @DisplayName("Convert mixed case to uppercase")
    public void testToUpperCase_MixedCase() {
        // Arrange
        String input = "HeLLo WoRLd";
        String expected = "HELLO WORLD";

        // Act
        String result = stringUtil.toUpperCase(input);

        // Assert
        assertEquals(expected, result,
            "Converting mixed case should produce all uppercase");
    }

    @Test
    @DisplayName("Convert empty string to uppercase")
    public void testToUpperCase_EmptyString() {
        // Arrange
        String input = "";
        String expected = "";

        // Act
        String result = stringUtil.toUpperCase(input);

        // Assert
        assertEquals(expected, result,
            "Converting empty string should return empty string");
    }

    // ========================================
    // GET LENGTH TESTS
    // ========================================

    @Test
    @DisplayName("Get length of normal string")
    public void testGetLength_NormalString() {
        // Arrange
        String input = "Hello";
        int expected = 5;

        // Act
        int result = stringUtil.getLength(input);

        // Assert
        assertEquals(expected, result,
            "Length of 'Hello' should be 5");
    }

    @Test
    @DisplayName("Get length of empty string")
    public void testGetLength_EmptyString() {
        // Arrange
        String input = "";
        int expected = 0;

        // Act
        int result = stringUtil.getLength(input);

        // Assert
        assertEquals(expected, result,
            "Length of empty string should be 0");
    }

    @Test
    @DisplayName("Get length of single character")
    public void testGetLength_SingleCharacter() {
        // Arrange
        String input = "A";
        int expected = 1;

        // Act
        int result = stringUtil.getLength(input);

        // Assert
        assertEquals(expected, result,
            "Length of single character should be 1");
    }

    @Test
    @DisplayName("Get length throws exception for null string")
    public void testGetLength_NullString_ThrowsException() {
        // Arrange
        String input = null;

        // Act & Assert
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> stringUtil.getLength(input),
            "Getting length of null string should throw IllegalArgumentException"
        );

        // Verify exception message
        assertEquals("String cannot be null", exception.getMessage(),
            "Exception message should be 'String cannot be null'");
    }
}
