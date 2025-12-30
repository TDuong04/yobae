# JUnit Practice Exam - COMPLETE SOLUTION

## ⚠️ Try the exam yourself first before looking at this!

This is the **complete answer** to the practice exam. Use this to check your work after you've attempted it.

---

## Part 1: Requirements and Planning (7.5 points)

### User Stories

**US-1: String Concatenation**
- As a user, I want to concatenate two strings together
- So that I can combine text from multiple sources
- Acceptance Criteria:
  - Given two strings "Hello" and "World", when I call concatenate(), then I get "HelloWorld"
  - Should handle empty strings
  - Should preserve the order (first string + second string)
  - Should work with special characters and numbers

**US-2: String Reversal**
- As a user, I want to reverse a string
- So that I can process text in reverse order
- Acceptance Criteria:
  - Given string "Hello", when I call reverse(), then I get "olleH"
  - Should handle empty strings (returns empty string)
  - Should handle single character strings
  - Should work with special characters

**US-3: Uppercase Conversion**
- As a user, I want to convert a string to uppercase
- So that I can normalize text for comparison
- Acceptance Criteria:
  - Given string "hello", when I call toUpperCase(), then I get "HELLO"
  - Should handle already uppercase strings
  - Should handle mixed case strings
  - Should handle empty strings
  - Should not affect numbers and special characters

**US-4: String Length Calculation**
- As a user, I want to get the length of a string
- So that I can validate input or limit text
- Acceptance Criteria:
  - Given string "Hello", when I call getLength(), then I get 5
  - Should return 0 for empty strings
  - Should throw IllegalArgumentException if string is null
  - Exception message should be "String cannot be null"

### Test Plan

**Testing Strategy:**
1. **Happy Path Tests**: Test each operation with normal, expected inputs
2. **Edge Case Tests**: Test with empty strings, single characters, special characters
3. **Boundary Tests**: Test with very long strings, mixed content
4. **Error Tests**: Test null handling for getLength()

**Specific Test Cases:**
- Concatenate: normal strings, empty strings, one empty/one filled
- Reverse: normal string, empty, palindrome, single character
- ToUpperCase: lowercase, uppercase, mixed, with numbers
- GetLength: normal string, empty string, null (exception)

**Expected Coverage:**
- Minimum 12 tests total (3 per operation)
- All edge cases covered
- Exception handling verified

---

## Part 2: Implementation (6 points)

### Code Implementation

```java
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
```

### Design Reasoning

**1. Why use @Service annotation?**
- Marks this class as a Spring service layer component
- Enables Spring's dependency injection and component scanning
- Allows the service to be autowired into other components (like controllers)
- Follows Spring best practices for business logic separation
- Makes the class a managed Spring bean with lifecycle management

**2. Why use IllegalArgumentException for null strings?**
- IllegalArgumentException is the standard Java exception for invalid method arguments
- A null string is a programming error (invalid argument), not a system error
- It's a runtime (unchecked) exception, so callers can choose whether to catch it
- The error message clearly indicates what went wrong ("String cannot be null")
- Follows Java conventions (similar to Integer.parseInt() throwing NumberFormatException)

**3. Why are the methods stateless?**
- Each method operates only on the parameters passed to it
- No instance variables means no shared state between calls
- Thread-safe by design - multiple threads can use the service simultaneously
- Easier to test - no need to set up or reset state between tests
- More predictable - same inputs always produce same outputs
- Follows functional programming principles

**4. Why use StringBuilder for reverse()?**
- StringBuilder provides a built-in, efficient reverse() method
- More efficient than manual character-by-character reversal
- Well-tested standard library code
- Clean, readable implementation

**5. Data type choices:**
- String parameters and returns: Natural choice for text manipulation
- int return for getLength(): Matches Java's String.length() API
- No need for wrapper types (Integer, etc.) as nulls aren't valid except where explicitly checked

---

## Part 3: Testing & Verification (11.5 points)

### Complete Test Code

```java
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
```

### Test Value Reasoning

**Concatenate Tests:**

1. **"Hello" + "World"**
   - Simple, recognizable English words
   - Different lengths (5 and 5 characters)
   - Tests basic functionality with common strings
   - Result "HelloWorld" is easy to verify visually

2. **"" + "Hello" and "Hello" + ""**
   - Tests edge case of empty string concatenation
   - Verifies that empty strings are handled correctly
   - Important because concatenation with empty should return the other string
   - Tests both positions (first and second parameter)

3. **"" + ""**
   - Boundary case: both strings empty
   - Should return empty string
   - Tests that concatenation doesn't add unexpected characters

**Reverse Tests:**

1. **"Hello" → "olleH"**
   - Common English word that's easy to reverse mentally
   - 5 characters - not too long, not too short
   - Result is clearly different from input
   - Good for visual verification

2. **"" → ""**
   - Edge case: empty string
   - Should return empty, not crash
   - Important boundary condition

3. **"A" → "A"**
   - Single character edge case
   - Reversing one character should return the same character
   - Tests minimum non-empty input

4. **"racecar" → "racecar"**
   - Palindrome test
   - Verifies reverse logic works even when result equals input
   - Good validation that we're not just returning the input

**ToUpperCase Tests:**

1. **"hello" → "HELLO"**
   - All lowercase input
   - Tests the primary use case
   - Simple, common word for easy verification

2. **"HELLO" → "HELLO"**
   - Already uppercase
   - Should not change the string
   - Tests idempotency (applying twice doesn't change result)

3. **"HeLLo WoRLd" → "HELLO WORLD"**
   - Mixed case input
   - Tests that all lowercase letters are converted
   - Includes space to verify non-letters are preserved
   - Realistic real-world scenario

4. **"" → ""**
   - Empty string edge case
   - Should handle gracefully

**GetLength Tests:**

1. **"Hello" → 5**
   - Standard case with common word
   - 5 is easy to count and verify
   - Tests basic functionality

2. **"" → 0**
   - Critical edge case
   - Empty string should have length 0
   - Common real-world scenario

3. **"A" → 1**
   - Minimum non-empty length
   - Boundary condition test
   - Single character is important edge case

4. **null → Exception**
   - Error case testing
   - null is invalid input and should throw exception
   - Chose IllegalArgumentException because it's a programming error
   - Verified exception message matches specification

**Overall Testing Philosophy:**
- Used simple, recognizable values for easy mental verification
- Covered normal cases, edge cases, and error cases
- Each test focuses on one specific scenario
- Test values are representative of real-world usage
- Chose values that make it obvious whether the test passes or fails

---

## Scoring Breakdown

### Part 1: Requirements and Planning - 7.5/7.5 ✅

- ✅ **User Stories (3.0/3.0):** Four clear user stories covering all operations
- ✅ **Acceptance Criteria (2.5/2.5):** Specific, testable criteria for each story
- ✅ **Test Plan (2.0/2.0):** Comprehensive strategy covering happy path, edge cases, and errors

### Part 2: Implementation & Design - 6.0/6.0 ✅

- ✅ **Working Code (3.0/3.0):** All methods implemented correctly
- ✅ **Annotations (1.0/1.0):** Proper @Service annotation used
- ✅ **Exception Handling (1.0/1.0):** Correct IllegalArgumentException for null
- ✅ **Design Reasoning (1.0/1.0):** Thorough explanation of all design choices

### Part 3: Testing & Verification - 11.5/11.5 ✅

- ✅ **Test Coverage (4.0/4.0):** 16 tests total (4 per operation, exceeds minimum)
- ✅ **Edge Cases (2.5/2.5):** Empty strings, single characters, palindrome tested
- ✅ **Exception Testing (2.0/2.0):** Proper assertThrows with message verification
- ✅ **Assertions (1.5/1.5):** Correct use of assertEquals with descriptive messages
- ✅ **Test Reasoning (1.5/1.5):** Detailed explanation of all test value choices

**Total Score: 25/25 (100%)** 🎉

---

## Key Takeaways

**What Made This Answer Perfect:**

1. ✅ **Complete Documentation:** Every decision was explained
2. ✅ **Beyond Minimum Requirements:** 16 tests instead of minimum 12
3. ✅ **Clear Organization:** Used sections, comments, and DisplayName annotations
4. ✅ **Edge Case Coverage:** Tested empty strings, single characters, null
5. ✅ **Proper Exception Testing:** Used assertThrows AND verified message
6. ✅ **Reasoning Throughout:** Explained WHY for test values and design choices
7. ✅ **Professional Code:** JavaDoc comments, descriptive names, AAA pattern
8. ✅ **Design Justification:** Explained @Service, IllegalArgumentException, stateless design

**What Would Lose Points:**

- ❌ Only 1-2 tests per operation (need 3+)
- ❌ No edge case testing
- ❌ Not testing exception case
- ❌ No explanation of test value choices
- ❌ No design reasoning
- ❌ Missing user stories or acceptance criteria
- ❌ Wrong exception type or no exception at all
- ❌ Using wrong assertion parameter order

---

## How to Use This Solution

1. **First:** Try the exam yourself without looking at this
2. **Then:** Compare your answer to this solution
3. **Check:** Did you cover all the same points?
4. **Learn:** Understand WHY each part is important
5. **Practice:** Try writing similar tests for different methods

Good luck on your actual exam! 🚀

