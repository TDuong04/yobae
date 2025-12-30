# JUnit Test Templates - Copy & Paste Ready

## Quick Reference: Test Template Structure

```java
@Test
@DisplayName("Description of what you're testing")
public void testMethodName_Scenario_ExpectedResult() {
    // Arrange: Set up test data
    CalculatorService calculator = new CalculatorService();
    int a = [first value];
    int b = [second value];
    int expected = [expected result];

    // Act: Perform the operation
    int result = calculator.[method](a, b);

    // Assert: Verify the result
    assertEquals(expected, result, "[Description of what should happen]");
}
```

---

## Template 1: Basic Arithmetic Test

**COPY THIS - Just change the values!**

```java
@Test
public void testAdd_MyScenario() {
    // CHANGE THESE VALUES ↓
    int a = 10;
    int b = 20;
    int expected = 30;
    // CHANGE THESE VALUES ↑

    CalculatorService calculator = new CalculatorService();
    int result = calculator.add(a, b);
    assertEquals(expected, result);
}
```

**How to Modify:**
1. Change `testAdd` to `testSubtract`, `testMultiply`, or `testDivide`
2. Change `calculator.add` to match: `.subtract()`, `.multiply()`, `.divide()`
3. Change the values of `a`, `b`, and `expected`

---

## Template 2: Exception Test (for Division by Zero)

**COPY THIS - Works as-is!**

```java
@Test
public void testDivide_ByZero_ThrowsException() {
    CalculatorService calculator = new CalculatorService();

    IllegalArgumentException exception = assertThrows(
        IllegalArgumentException.class,
        () -> calculator.divide(10, 0)
    );

    assertEquals("Cannot divide by zero", exception.getMessage());
}
```

**How to Modify:**
- Change the first number (10) to any value
- Keep the second number as 0 (that's what causes the exception)

---

## Template 3: Test with BeforeEach Setup

**COPY THIS - Cleaner code for multiple tests!**

```java
public class MyCalculatorTest {

    private CalculatorService calculator;

    @BeforeEach
    public void setUp() {
        calculator = new CalculatorService();
    }

    @Test
    public void testAdd() {
        int result = calculator.add(5, 3);
        assertEquals(8, result);
    }

    @Test
    public void testSubtract() {
        int result = calculator.subtract(10, 3);
        assertEquals(7, result);
    }

    // Add more tests here...
}
```

---

## Template 4: Test with Descriptive Comments

**COPY THIS - Great for showing your thinking!**

```java
@Test
public void testMultiply_PositiveNumbers() {
    // Arrange: Prepare test data
    // Using 6 and 7 because they're simple prime numbers
    // that produce an easily recognizable result (42)
    int a = 6;
    int b = 7;
    int expected = 42;

    // Act: Execute the method under test
    CalculatorService calculator = new CalculatorService();
    int result = calculator.multiply(a, b);

    // Assert: Verify the result matches expectations
    // This confirms multiplication works correctly for positive integers
    assertEquals(expected, result,
        "Multiplication of 6 and 7 should equal 42");
}
```

---

## Complete Test Class Template

**COPY THIS ENTIRE CLASS - Ready to use!**

```java
package com.example.calculatorservice.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorServiceTest {

    private CalculatorService calculator;

    @BeforeEach
    public void setUp() {
        calculator = new CalculatorService();
    }

    // ========== ADDITION TESTS ==========

    @Test
    public void testAdd_PositiveNumbers() {
        int result = calculator.add(3, 5);
        assertEquals(8, result);
    }

    @Test
    public void testAdd_WithZero() {
        int result = calculator.add(5, 0);
        assertEquals(5, result);
    }

    @Test
    public void testAdd_NegativeNumbers() {
        int result = calculator.add(-5, -3);
        assertEquals(-8, result);
    }

    // ========== SUBTRACTION TESTS ==========

    @Test
    public void testSubtract_PositiveNumbers() {
        int result = calculator.subtract(10, 4);
        assertEquals(6, result);
    }

    @Test
    public void testSubtract_ResultNegative() {
        int result = calculator.subtract(4, 10);
        assertEquals(-6, result);
    }

    @Test
    public void testSubtract_WithZero() {
        int result = calculator.subtract(10, 0);
        assertEquals(10, result);
    }

    // ========== MULTIPLICATION TESTS ==========

    @Test
    public void testMultiply_PositiveNumbers() {
        int result = calculator.multiply(6, 7);
        assertEquals(42, result);
    }

    @Test
    public void testMultiply_ByZero() {
        int result = calculator.multiply(5, 0);
        assertEquals(0, result);
    }

    @Test
    public void testMultiply_NegativeNumbers() {
        int result = calculator.multiply(-3, 4);
        assertEquals(-12, result);
    }

    // ========== DIVISION TESTS ==========

    @Test
    public void testDivide_EvenDivision() {
        int result = calculator.divide(20, 4);
        assertEquals(5, result);
    }

    @Test
    public void testDivide_WithRemainder() {
        int result = calculator.divide(10, 3);
        assertEquals(3, result); // Integer division
    }

    @Test
    public void testDivide_ZeroDividend() {
        int result = calculator.divide(0, 5);
        assertEquals(0, result);
    }

    @Test
    public void testDivide_ByZero_ThrowsException() {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> calculator.divide(10, 0)
        );
        assertEquals("Cannot divide by zero", exception.getMessage());
    }
}
```

---

## Quick Copy: Individual Test Examples

### Addition Examples

```java
@Test
public void testAdd_Example1() {
    assertEquals(10, calculator.add(7, 3));
}

@Test
public void testAdd_Example2() {
    assertEquals(0, calculator.add(-5, 5));
}

@Test
public void testAdd_Example3() {
    assertEquals(-8, calculator.add(-3, -5));
}
```

### Subtraction Examples

```java
@Test
public void testSubtract_Example1() {
    assertEquals(5, calculator.subtract(10, 5));
}

@Test
public void testSubtract_Example2() {
    assertEquals(-3, calculator.subtract(2, 5));
}

@Test
public void testSubtract_Example3() {
    assertEquals(0, calculator.subtract(7, 7));
}
```

### Multiplication Examples

```java
@Test
public void testMultiply_Example1() {
    assertEquals(24, calculator.multiply(6, 4));
}

@Test
public void testMultiply_Example2() {
    assertEquals(0, calculator.multiply(100, 0));
}

@Test
public void testMultiply_Example3() {
    assertEquals(15, calculator.multiply(-3, -5));
}
```

### Division Examples

```java
@Test
public void testDivide_Example1() {
    assertEquals(4, calculator.divide(20, 5));
}

@Test
public void testDivide_Example2() {
    assertEquals(2, calculator.divide(7, 3)); // 7/3 = 2 remainder 1
}

@Test
public void testDivide_Example3() {
    assertEquals(-5, calculator.divide(-15, 3));
}
```

---

## Common Mistakes to Avoid

### ❌ WRONG:
```java
@Test
public void testAdd() {
    assertEquals(calculator.add(3, 5), 8); // Parameters reversed!
}
```

### ✅ CORRECT:
```java
@Test
public void testAdd() {
    assertEquals(8, calculator.add(3, 5)); // Expected first, actual second
}
```

---

### ❌ WRONG:
```java
@Test
public void testDivideByZero() {
    calculator.divide(10, 0); // No assertion! Test will fail
}
```

### ✅ CORRECT:
```java
@Test
public void testDivideByZero() {
    assertThrows(IllegalArgumentException.class, () -> {
        calculator.divide(10, 0);
    });
}
```

---

## Import Statements You Need

**Always include at the top of your test file:**

```java
package com.example.calculatorservice.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
```

---

## Running Your Tests

### Command Line:
```bash
mvn test
```

### In IDE (IntelliJ/Eclipse):
- Right-click on the test file
- Select "Run 'CalculatorServiceTest'"

---

## Quick Checklist Before Submitting

- [ ] All tests have `@Test` annotation
- [ ] Test methods are public void
- [ ] Test names are descriptive
- [ ] Each test has an assertion (assertEquals, assertThrows, etc.)
- [ ] Division by zero test uses assertThrows
- [ ] All imports are correct
- [ ] Tests actually pass when you run them!
