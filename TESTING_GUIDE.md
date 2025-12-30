# Calculator Service - Testing Guide

## Requirements and Planning

### User Stories

**US-1: Addition Operation**
- As a user, I want to add two integers together
- So that I can perform basic arithmetic calculations
- Acceptance Criteria:
  - Given two integers, when I call add(a, b), then it returns their sum
  - Should handle positive numbers
  - Should handle negative numbers
  - Should handle zero

**US-2: Subtraction Operation**
- As a user, I want to subtract one integer from another
- So that I can perform basic arithmetic calculations
- Acceptance Criteria:
  - Given two integers, when I call subtract(a, b), then it returns a - b
  - Should handle positive results
  - Should handle negative results
  - Should handle zero

**US-3: Multiplication Operation**
- As a user, I want to multiply two integers
- So that I can perform basic arithmetic calculations
- Acceptance Criteria:
  - Given two integers, when I call multiply(a, b), then it returns their product
  - Should handle positive numbers
  - Should handle negative numbers
  - Should handle zero

**US-4: Division Operation**
- As a user, I want to divide one integer by another
- So that I can perform basic arithmetic calculations
- Acceptance Criteria:
  - Given two integers, when I call divide(a, b), then it returns a / b
  - Should handle normal division
  - Should throw IllegalArgumentException when dividing by zero
  - Exception message should be "Cannot divide by zero"

---

## Implementation Design Reasoning

### Why Use @Service Annotation?
- Spring's `@Service` annotation marks this class as a service layer component
- Enables dependency injection and Spring container management
- Follows Spring best practices for business logic components

### Why Use Integer (int) Return Type?
- Calculator operations on whole numbers don't require decimal precision
- Integer division returns whole numbers (standard Java behavior)
- Simple and efficient for basic arithmetic

### Why IllegalArgumentException for Division by Zero?
- IllegalArgumentException is appropriate for invalid method arguments
- Division by zero is a programming error, not a checked exception
- Clear, descriptive error message helps with debugging

### Design Pattern: Simple Service Layer
- Single Responsibility Principle: Each method does one thing
- No state management: Pure functions (stateless)
- Easy to test: No dependencies or side effects

---

## Testing Strategy

### Test Categories

1. **Happy Path Tests**: Normal, expected inputs
2. **Boundary Tests**: Edge cases like zero, negative numbers
3. **Exception Tests**: Invalid inputs that should throw exceptions

### Choice of Test Values - Reasoning

#### Addition Tests
- `add(3, 5) = 8`: Simple positive numbers
- `add(-5, 3) = -2`: Mixed positive/negative
- `add(0, 0) = 0`: Zero edge case
- `add(100, -100) = 0`: Large numbers canceling out

#### Subtraction Tests
- `subtract(10, 4) = 6`: Simple positive result
- `subtract(5, 10) = -5`: Negative result
- `subtract(0, 5) = -5`: Zero as first operand
- `subtract(5, 0) = 5`: Zero as second operand

#### Multiplication Tests
- `multiply(6, 7) = 42`: Standard multiplication
- `multiply(5, 0) = 0`: Multiplication by zero
- `multiply(-3, 4) = -12`: Negative number
- `multiply(-3, -4) = 12`: Two negatives make positive

#### Division Tests
- `divide(20, 4) = 5`: Standard division
- `divide(10, 3) = 3`: Integer division (truncates)
- `divide(0, 5) = 0`: Zero as dividend
- `divide(10, 0)`: Should throw IllegalArgumentException

---

## JUnit Testing Best Practices

### 1. Test Method Naming Convention
```java
@Test
public void testMethodName_Scenario_ExpectedBehavior()
```

### 2. AAA Pattern (Arrange-Act-Assert)
```java
@Test
public void testAdd() {
    // Arrange: Set up test data
    CalculatorService calculator = new CalculatorService();

    // Act: Perform the operation
    int result = calculator.add(3, 5);

    // Assert: Verify the result
    assertEquals(8, result);
}
```

### 3. Test One Thing Per Test
- Each test method should verify one specific behavior
- Makes failures easier to diagnose
- Keeps tests maintainable

### 4. Use Descriptive Assertions
```java
assertEquals(expected, actual, "Error message if assertion fails");
```

---

## Common JUnit Assertions

```java
import static org.junit.jupiter.api.Assertions.*;

// Equality
assertEquals(expected, actual);
assertNotEquals(unexpected, actual);

// Boolean
assertTrue(condition);
assertFalse(condition);

// Null checks
assertNull(object);
assertNotNull(object);

// Exceptions
assertThrows(ExceptionType.class, () -> {
    // Code that should throw exception
});

// Array equality
assertArrayEquals(expectedArray, actualArray);
```

---

## How to Run Tests

### Using Maven (Command Line)
```bash
mvn test                    # Run all tests
mvn test -Dtest=ClassName   # Run specific test class
```

### Using IDE
- Right-click on test class or method
- Select "Run Test" or "Debug Test"

---

## Test Coverage Goals

- **Line Coverage**: 100% of all lines executed
- **Branch Coverage**: 100% of all if/else branches tested
- **Method Coverage**: 100% of all public methods tested
- **Edge Cases**: All boundary conditions tested
