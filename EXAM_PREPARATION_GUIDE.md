# JUnit Exam Preparation Guide

## How to Score Full Marks

### Criterion 1: Requirements and Planning (7.5 points)

**What they're looking for:**
- Clear understanding of the problem
- User stories or specifications
- Planning before coding

**How to demonstrate this:**

```markdown
## Problem Statement
Create a calculator service that performs basic arithmetic operations.

## User Stories

US-1: As a user, I want to add two numbers
- Acceptance Criteria: Given two integers, return their sum

US-2: As a user, I want to subtract two numbers
- Acceptance Criteria: Given two integers, return the difference

US-3: As a user, I want to multiply two numbers
- Acceptance Criteria: Given two integers, return the product

US-4: As a user, I want to divide two numbers
- Acceptance Criteria: Given two integers, return the quotient
- Error Handling: Throw exception when dividing by zero

## Test Plan
1. Test happy paths (normal inputs)
2. Test edge cases (zero, negatives)
3. Test error conditions (division by zero)
```

---

### Criterion 2: Implementation Coding & Design Reasoning (6 points)

**What they're looking for:**
- Working Java code
- Explanation of design decisions

**Example Design Reasoning to Write:**

```java
/**
 * Calculator Service Implementation
 *
 * DESIGN DECISIONS:
 *
 * 1. Why @Service annotation?
 *    - Marks this as a Spring service component
 *    - Enables dependency injection
 *    - Follows Spring best practices
 *
 * 2. Why use 'int' instead of 'double'?
 *    - Requirements specify integer arithmetic
 *    - Integer division is standard Java behavior
 *    - Simpler and more efficient for whole numbers
 *
 * 3. Why IllegalArgumentException for divide by zero?
 *    - It's an invalid argument (programming error)
 *    - Runtime exception (unchecked)
 *    - Caller can catch it if needed
 *    - Clear, descriptive error message
 *
 * 4. Why no instance variables (stateless)?
 *    - Each method is independent
 *    - Thread-safe by default
 *    - Easier to test
 *    - Follows functional programming principles
 */
@Service
public class CalculatorService {
    // Implementation...
}
```

**Key Points to Mention:**
- Why you chose specific data types
- Why you chose specific exceptions
- Why methods are stateless
- How Spring annotations help

---

### Criterion 3: Testing & Verification (11.5 points) ⭐ MOST IMPORTANT

**What they're looking for:**
- JUnit test code
- Proper assertions
- Good choice of test values
- Reasoning for test choices

**How to Score Full Marks:**

#### 1. Write Multiple Test Cases Per Method

```java
// DON'T just write ONE test:
@Test
public void testAdd() {
    assertEquals(8, calculator.add(3, 5));
}

// DO write MULTIPLE tests covering different scenarios:
@Test
public void testAdd_PositiveNumbers() {
    assertEquals(8, calculator.add(3, 5));
}

@Test
public void testAdd_WithZero() {
    assertEquals(5, calculator.add(5, 0));
}

@Test
public void testAdd_NegativeNumbers() {
    assertEquals(-8, calculator.add(-5, -3));
}

@Test
public void testAdd_MixedSigns() {
    assertEquals(2, calculator.add(5, -3));
}
```

#### 2. Explain Your Test Value Choices

**Add this reasoning in comments or separate document:**

```java
@Test
public void testMultiply_StandardCase() {
    // REASONING: Chose 6 and 7 because:
    // - They are both prime numbers
    // - Result (42) is well-known and easy to verify
    // - Tests standard positive multiplication
    assertEquals(42, calculator.multiply(6, 7));
}

@Test
public void testMultiply_ByZero() {
    // REASONING: Chose to test with zero because:
    // - Zero is a critical edge case in multiplication
    // - Verifies the "multiplicative property of zero"
    // - Any number times zero should be zero
    assertEquals(0, calculator.multiply(5, 0));
}

@Test
public void testMultiply_TwoNegatives() {
    // REASONING: Chose two negative numbers because:
    // - Tests the rule "negative × negative = positive"
    // - Ensures sign handling works correctly
    // - -3 and -4 are small, easy to calculate mentally
    assertEquals(12, calculator.multiply(-3, -4));
}
```

#### 3. Test Different Categories

**Create tests for these categories:**

| Category | Example | Why Important |
|----------|---------|---------------|
| Happy Path | `add(5, 3) = 8` | Normal expected usage |
| Zero Edge Case | `multiply(x, 0) = 0` | Zero has special properties |
| Negative Numbers | `add(-5, -3) = -8` | Tests sign handling |
| Mixed Signs | `add(5, -3) = 2` | Tests positive/negative interaction |
| Large Numbers | `add(1000, 2000) = 3000` | Tests no overflow issues |
| Same Numbers | `subtract(5, 5) = 0` | Tests self-operation |
| Exception Case | `divide(x, 0)` throws | Tests error handling |

#### 4. Proper Assertion Usage

```java
// BASIC assertion
assertEquals(expected, actual);

// BETTER: With descriptive message
assertEquals(8, calculator.add(3, 5),
    "Adding 3 and 5 should return 8");

// EXCEPTION testing
assertThrows(IllegalArgumentException.class,
    () -> calculator.divide(10, 0),
    "Division by zero should throw IllegalArgumentException");

// VERIFY exception message too!
IllegalArgumentException exception = assertThrows(
    IllegalArgumentException.class,
    () -> calculator.divide(10, 0)
);
assertEquals("Cannot divide by zero", exception.getMessage());
```

---

## Example: Complete Test with Full Documentation

```java
/**
 * Test Suite for Division Operation
 *
 * TEST STRATEGY:
 * 1. Test normal division (20 ÷ 4 = 5)
 * 2. Test integer division with remainder (10 ÷ 3 = 3)
 * 3. Test division by 1 (identity property)
 * 4. Test division of zero (0 ÷ 5 = 0)
 * 5. Test negative numbers
 * 6. Test division by zero (exception case)
 *
 * VALUE CHOICES:
 * - Used simple numbers for easy mental verification
 * - Included edge cases (zero, negative, by one)
 * - Tested both even division and truncation
 */

@Test
public void testDivide_EvenDivision() {
    // REASONING: 20 ÷ 4 = 5 is a clean division
    // Tests the basic happy path with no remainder
    int result = calculator.divide(20, 4);
    assertEquals(5, result, "20 divided by 4 should equal 5");
}

@Test
public void testDivide_IntegerTruncation() {
    // REASONING: 10 ÷ 3 = 3.333...
    // In integer division, this truncates to 3
    // This tests that we understand Java's integer division behavior
    int result = calculator.divide(10, 3);
    assertEquals(3, result,
        "10 divided by 3 should equal 3 (integer division truncates)");
}

@Test
public void testDivide_ByOne() {
    // REASONING: Tests the identity property of division
    // Any number divided by 1 should equal itself
    // Chose 42 as a recognizable test value
    int result = calculator.divide(42, 1);
    assertEquals(42, result, "42 divided by 1 should equal 42");
}

@Test
public void testDivide_ZeroDividend() {
    // REASONING: 0 divided by anything (except 0) should be 0
    // This is an important mathematical edge case
    int result = calculator.divide(0, 5);
    assertEquals(0, result, "0 divided by 5 should equal 0");
}

@Test
public void testDivide_NegativeResult() {
    // REASONING: Tests sign handling in division
    // Negative ÷ Positive = Negative
    // Used -20 and 4 for easy calculation
    int result = calculator.divide(-20, 4);
    assertEquals(-5, result, "-20 divided by 4 should equal -5");
}

@Test
public void testDivide_TwoNegatives() {
    // REASONING: Tests the rule "negative ÷ negative = positive"
    // Ensures proper sign handling
    int result = calculator.divide(-20, -4);
    assertEquals(5, result, "-20 divided by -4 should equal 5");
}

@Test
public void testDivide_ByZero_ThrowsException() {
    // REASONING: Division by zero is mathematically undefined
    // Our design decision: throw IllegalArgumentException
    // This is a runtime exception appropriate for invalid arguments

    IllegalArgumentException exception = assertThrows(
        IllegalArgumentException.class,
        () -> calculator.divide(10, 0),
        "Dividing by zero should throw IllegalArgumentException"
    );

    // ALSO verify the exception message is correct
    assertEquals("Cannot divide by zero", exception.getMessage(),
        "Exception message should match our specification");
}
```

---

## Sample Exam Answers

### Question: "Why did you choose these test values?"

**GOOD ANSWER:**
```
I chose my test values strategically to cover multiple scenarios:

1. Simple positive numbers (3, 5): Easy to verify mentally, tests basic functionality
2. Zero values: Critical edge case that often reveals bugs
3. Negative numbers: Tests sign handling and ensures correct arithmetic
4. Large numbers (1000, 2000): Verifies no overflow issues
5. Same numbers (5, 5): Tests boundary where result is zero or one

For division specifically:
- Even division (20÷4): Tests happy path
- Division with remainder (10÷3): Tests integer truncation
- Division by zero: Tests exception handling

Each value was chosen to test a specific aspect of the implementation.
```

---

### Question: "Explain your testing strategy"

**GOOD ANSWER:**
```
My testing strategy follows the Arrange-Act-Assert (AAA) pattern and covers:

1. Happy Path Tests: Normal, expected inputs that should work
   Example: add(3, 5) = 8

2. Boundary/Edge Cases: Special values that might cause issues
   Example: multiply(x, 0), divide(0, x)

3. Error Cases: Invalid inputs that should trigger exceptions
   Example: divide(x, 0) should throw IllegalArgumentException

4. Sign Combinations: Positive, negative, mixed
   Example: Testing that -3 * -4 = 12

I used JUnit 5's assertions (assertEquals, assertThrows) to verify:
- Correct return values
- Correct exception types
- Correct exception messages

This ensures comprehensive coverage and high confidence in the code.
```

---

## Quick Checklist Before Exam

### Requirements & Planning ✓
- [ ] Written user stories or problem statement
- [ ] Listed acceptance criteria
- [ ] Created test plan

### Implementation & Design ✓
- [ ] Code works correctly
- [ ] Added @Service annotation
- [ ] Explained why IllegalArgumentException for divide by zero
- [ ] Explained why methods are stateless
- [ ] Explained data type choices

### Testing & Verification ✓
- [ ] At least 3-4 tests per operation (add, subtract, multiply, divide)
- [ ] Tests cover happy path
- [ ] Tests cover edge cases (zero, negatives)
- [ ] Tests cover error cases (divide by zero)
- [ ] Used proper assertions (assertEquals, assertThrows)
- [ ] Verified exception messages
- [ ] Added reasoning for test value choices
- [ ] All tests pass when run

---

## Time Management Tips

**If you have 60 minutes:**
- 10 min: Planning & writing requirements
- 20 min: Writing implementation code
- 25 min: Writing comprehensive tests
- 5 min: Review and add comments/reasoning

**Priority:**
1. Get basic implementation working
2. Write tests that pass
3. Add edge case tests
4. Add reasoning/comments
5. Polish and review

---

## Final Tips

1. **Comment your reasoning** - Don't just write code, explain WHY
2. **Test edge cases** - Zero, negatives, exceptions
3. **Use descriptive names** - `testAdd_PositiveNumbers` not just `test1`
4. **Verify it works** - Actually run your tests before submitting
5. **Show your thinking** - Explain test value choices

Good luck on your exam! 🎓
