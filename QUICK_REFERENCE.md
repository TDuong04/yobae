# JUnit Quick Reference Card - For Your Exam

## Essential Imports (Copy First!)

```java
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
```

---

## Most Common Test Pattern (Copy & Modify)

```java
@Test
public void test[Method]_[Scenario]() {
    // Arrange
    CalculatorService calc = new CalculatorService();

    // Act
    int result = calc.[method]([value1], [value2]);

    // Assert
    assertEquals([expected], result);
}
```

---

## Exception Test Pattern (Copy for Divide by Zero)

```java
@Test
public void testDivide_ByZero_ThrowsException() {
    CalculatorService calc = new CalculatorService();

    assertThrows(IllegalArgumentException.class,
        () -> calc.divide(10, 0));
}
```

---

## Test Values Cheat Sheet

### Addition
```
add(3, 5) = 8           // Simple positive
add(-5, 3) = -2         // Mixed signs
add(0, 0) = 0           // Zeros
add(100, -100) = 0      // Canceling
```

### Subtraction
```
subtract(10, 4) = 6     // Positive result
subtract(4, 10) = -6    // Negative result
subtract(5, 0) = 5      // Subtract zero
subtract(5, 5) = 0      // Same numbers
```

### Multiplication
```
multiply(6, 7) = 42     // Standard
multiply(5, 0) = 0      // By zero
multiply(-3, 4) = -12   // One negative
multiply(-3, -4) = 12   // Both negative
```

### Division
```
divide(20, 4) = 5       // Even division
divide(10, 3) = 3       // Integer truncation
divide(0, 5) = 0        // Zero dividend
divide(-20, 4) = -5     // Negative result
divide(10, 0) → Exception  // ERROR CASE
```

---

## Common Assertions

```java
assertEquals(expected, actual)
assertNotEquals(unexpected, actual)
assertTrue(condition)
assertFalse(condition)
assertNull(object)
assertNotNull(object)
assertThrows(Exception.class, () -> code)
```

---

## Scoring Points - Quick Checklist

### Requirements (7.5 pts)
```
✓ User story: "As a user, I want to add numbers..."
✓ Acceptance criteria: "Given two integers..."
✓ Test plan: "Test normal cases, edge cases, errors"
```

### Design Reasoning (6 pts)
```
✓ Why @Service? "Spring dependency injection"
✓ Why int? "Integer arithmetic requirement"
✓ Why IllegalArgumentException? "Invalid argument error"
✓ Why stateless? "Thread-safe, easier to test"
```

### Testing (11.5 pts) ⭐
```
✓ 3+ tests per method
✓ Test happy path
✓ Test edge cases (zero, negative)
✓ Test exceptions
✓ Explain test value choices
✓ All tests pass!
```

---

## 30-Second Test Template

```java
@Test
public void testAdd_Basic() {
    CalculatorService c = new CalculatorService();
    assertEquals(8, c.add(3, 5));
}

@Test
public void testSubtract_Basic() {
    CalculatorService c = new CalculatorService();
    assertEquals(6, c.subtract(10, 4));
}

@Test
public void testMultiply_Basic() {
    CalculatorService c = new CalculatorService();
    assertEquals(42, c.multiply(6, 7));
}

@Test
public void testDivide_Basic() {
    CalculatorService c = new CalculatorService();
    assertEquals(5, c.divide(20, 4));
}

@Test
public void testDivide_ByZero() {
    CalculatorService c = new CalculatorService();
    assertThrows(IllegalArgumentException.class,
        () -> c.divide(10, 0));
}
```

---

## Common Mistakes - DON'T DO THIS!

### ❌ Wrong Order
```java
assertEquals(calculator.add(3, 5), 8); // WRONG!
```

### ✅ Correct Order
```java
assertEquals(8, calculator.add(3, 5)); // RIGHT!
```

---

### ❌ No Assertion
```java
@Test
public void test() {
    calculator.add(3, 5); // WRONG! No assertion
}
```

### ✅ Has Assertion
```java
@Test
public void test() {
    assertEquals(8, calculator.add(3, 5)); // RIGHT!
}
```

---

### ❌ Wrong Exception Test
```java
@Test
public void test() {
    calculator.divide(10, 0); // WRONG! Doesn't catch exception
}
```

### ✅ Correct Exception Test
```java
@Test
public void test() {
    assertThrows(IllegalArgumentException.class,
        () -> calculator.divide(10, 0)); // RIGHT!
}
```

---

## What to Write on Paper/Comments

**For each test, briefly note:**

```java
@Test
public void testMultiply_ByZero() {
    // REASONING: Tests multiplicative property of zero
    // Any number × 0 should equal 0
    // Chose 5 as a simple test value
    assertEquals(0, calculator.multiply(5, 0));
}
```

---

## Time-Saving Tips

1. **Use BeforeEach** to avoid repeating `new CalculatorService()`
2. **Copy-paste tests** and just change values
3. **Write simple tests first**, add complexity later
4. **Run tests often** to catch errors early
5. **Add comments last** if time is tight

---

## If You Forget Everything Else, Remember This:

```java
// 1. Basic test structure
@Test
public void testSomething() {
    CalculatorService c = new CalculatorService();
    assertEquals(EXPECTED, c.method(INPUT));
}

// 2. Exception test structure
@Test
public void testException() {
    CalculatorService c = new CalculatorService();
    assertThrows(ExceptionType.class, () -> c.method(INPUT));
}

// 3. Write multiple tests for each operation
// 4. Test normal, zero, negative, and error cases
// 5. Explain your reasoning!
```

---

## Emergency 5-Minute Study Guide

**Must Know:**
1. `assertEquals(expected, actual)` - order matters!
2. `assertThrows(Exception.class, () -> code)` - for exceptions
3. Test at least 3 scenarios per method
4. Division by zero throws `IllegalArgumentException`
5. Always use `@Test` annotation

**Practice This Once:**
Write one complete test for add, subtract, multiply, divide, and divide-by-zero.
If you can do that, you can handle the exam!

---

Good luck! You've got this! 🚀
