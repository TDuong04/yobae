# JUnit Practice Exam

## 📋 Exam Instructions

**Time Limit:** 60 minutes
**Total Points:** 25 points

**Grading Breakdown:**
- Requirements and Planning: 7.5 points
- Implementation Coding & Design Reasoning: 6 points
- Testing & Verification: 11.5 points

---

## 📝 Exam Question

### Problem Statement

Create a **StringUtility Service** that provides basic string manipulation operations. Your service must include the following methods:

1. **concatenate(String a, String b)** - Combines two strings together
2. **reverse(String s)** - Reverses a string
3. **toUpperCase(String s)** - Converts string to uppercase
4. **getLength(String s)** - Returns the length of a string, throws exception if string is null

---

## Part 1: Requirements and Planning (7.5 points)

Write clear requirements for your StringUtility service.

**Instructions:**
1. Write user stories for each operation (format: "As a user, I want to...")
2. Define acceptance criteria for each user story
3. Create a test plan outlining what scenarios you will test

**Answer Space:**

```
[Write your answer here]

Example format:
User Story 1: As a user, I want to concatenate two strings...
Acceptance Criteria:
  - Given two strings "Hello" and "World", when I concatenate them, then I get "HelloWorld"
  - ...

Test Plan:
  1. Test happy path with normal strings
  2. Test with empty strings
  3. ...
```

---

## Part 2: Implementation (6 points)

Implement the StringUtility service with proper Spring annotations and design.

**Instructions:**
1. Create a class called `StringUtility` with `@Service` annotation
2. Implement all four methods
3. Add validation: `getLength()` should throw `IllegalArgumentException` if the string is null
4. Explain your design decisions

**Code Space:**

```java
package com.example.calculatorservice.service;

import org.springframework.stereotype.Service;

// TODO: Write your implementation here



```

**Design Reasoning Space:**

```
[Explain your design decisions here]

Example:
1. Why did you use @Service annotation?
2. Why did you choose IllegalArgumentException for null strings?
3. Why are the methods stateless?
```

---

## Part 3: Testing & Verification (11.5 points)

Write comprehensive JUnit tests for your StringUtility service.

**Requirements:**
- Write at least **3 tests** for each operation (12+ tests total)
- Include edge cases (empty strings, null values)
- Test the exception case for `getLength(null)`
- Use proper assertions
- Explain your choice of test values

**Test Code Space:**

```java
package com.example.calculatorservice.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class StringUtilityTest {

    // TODO: Write your tests here




}
```

**Test Value Reasoning Space:**

```
[Explain why you chose specific test values]

Example:
For concatenate("Hello", "World"):
- Chose "Hello" and "World" because...
- This tests...
```

---

## Grading Rubric

### Requirements and Planning (7.5 points)

| Criteria | Points | What to Include |
|----------|--------|-----------------|
| User Stories | 3.0 | 4 clear user stories, one for each operation |
| Acceptance Criteria | 2.5 | Specific, testable criteria for each story |
| Test Plan | 2.0 | Clear outline of what will be tested |

### Implementation & Design (6 points)

| Criteria | Points | What to Include |
|----------|--------|-----------------|
| Working Code | 3.0 | All 4 methods implemented correctly |
| Annotations | 1.0 | Proper use of @Service |
| Exception Handling | 1.0 | Correct exception for null string |
| Design Reasoning | 1.0 | Clear explanation of design choices |

### Testing & Verification (11.5 points)

| Criteria | Points | What to Include |
|----------|--------|-----------------|
| Test Coverage | 4.0 | At least 3 tests per operation (12+ total) |
| Edge Cases | 2.5 | Empty strings, null values tested |
| Exception Testing | 2.0 | Proper assertThrows for null case |
| Assertions | 1.5 | Correct use of assertEquals, etc. |
| Test Reasoning | 1.5 | Explanation of test value choices |

---

## 💡 Hints

<details>
<summary>Click to reveal hints (try without first!)</summary>

**For concatenate:**
- Test: "Hello" + "World" = "HelloWorld"
- Test: "" + "Hello" = "Hello"
- Test: "Hello" + "" = "Hello"

**For reverse:**
- Test: "Hello" → "olleH"
- Test: "" → ""
- Test: "A" → "A"

**For toUpperCase:**
- Test: "hello" → "HELLO"
- Test: "HeLLo" → "HELLO"
- Test: "" → ""

**For getLength:**
- Test: "Hello" → 5
- Test: "" → 0
- Test: null → throws IllegalArgumentException

**Implementation hints:**
```java
public String concatenate(String a, String b) {
    return a + b;
}

public String reverse(String s) {
    return new StringBuilder(s).reverse().toString();
}

public String toUpperCase(String s) {
    return s.toUpperCase();
}

public int getLength(String s) {
    if (s == null) {
        throw new IllegalArgumentException("String cannot be null");
    }
    return s.length();
}
```

</details>

---

## ⏱️ Time Management Suggestion

- **0-10 min:** Write requirements and planning (Part 1)
- **10-25 min:** Write implementation and design reasoning (Part 2)
- **25-55 min:** Write comprehensive tests (Part 3)
- **55-60 min:** Review, add comments, verify tests would pass

---

## ✅ Self-Check Before Submitting

- [ ] Written 4 user stories with acceptance criteria
- [ ] Created test plan
- [ ] Implemented all 4 methods in StringUtility
- [ ] Added @Service annotation
- [ ] Null check in getLength with IllegalArgumentException
- [ ] Explained design decisions
- [ ] Written at least 12 tests (3 per operation)
- [ ] Tested edge cases (empty strings, null)
- [ ] Used assertThrows for null case
- [ ] Verified exception message
- [ ] Explained test value choices
- [ ] Used proper assertions (assertEquals, assertThrows)

---

Good luck! Remember: Show your thinking, explain your choices, and cover edge cases!

