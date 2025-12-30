# Complete JUnit Practice Guide

## 🎯 Everything You Have for Exam Preparation

### 📊 Summary of Materials

You now have **3 complete working implementations** with **65 passing tests**!

---

## ✅ Working Implementations

### 1. Calculator Service (Original - Your Exam Topic)
**File:** [CalculatorService.java](src/main/java/com/example/calculatorservice/service/CalculatorService.java)

**Operations:**
- `add(int a, int b)` - Addition
- `subtract(int a, int b)` - Subtraction
- `multiply(int a, int b)` - Multiplication
- `divide(int a, int b)` - Division (throws exception for divide by zero)

**Tests:** 32 total
- [CalculatorServiceTest.java](src/test/java/com/example/calculatorservice/service/CalculatorServiceTest.java) - 5 basic tests
- [CalculatorServiceComprehensiveTest.java](src/test/java/com/example/calculatorservice/service/CalculatorServiceComprehensiveTest.java) - 27 comprehensive tests

**Why Practice This:**
- Integer arithmetic
- Exception handling
- Most similar to typical exam questions

---

### 2. String Utility (Practice Exam)
**File:** [StringUtility.java](src/main/java/com/example/calculatorservice/service/StringUtility.java)

**Operations:**
- `concatenate(String a, String b)` - Combine strings
- `reverse(String s)` - Reverse string
- `toUpperCase(String s)` - Convert to uppercase
- `getLength(String s)` - Get length (throws exception for null)

**Tests:** 16 total
- [StringUtilityTest.java](src/test/java/com/example/calculatorservice/service/StringUtilityTest.java) - 16 comprehensive tests

**Practice Materials:**
- [PRACTICE_EXAM.md](PRACTICE_EXAM.md) - Full 60-minute exam
- [PRACTICE_EXAM_SOLUTION.md](PRACTICE_EXAM_SOLUTION.md) - Complete answer (25/25 score)

**Why Practice This:**
- String operations
- Different data type than Calculator
- Null handling patterns

---

### 3. Temperature Converter (NEW!)
**File:** [TemperatureConverter.java](src/main/java/com/example/calculatorservice/service/TemperatureConverter.java)

**Operations:**
- `celsiusToFahrenheit(double celsius)` - C to F conversion
- `fahrenheitToCelsius(double fahrenheit)` - F to C conversion
- `isValidCelsius(double celsius)` - Check if above absolute zero
- `kelvinToCelsius(double kelvin)` - K to C (throws exception for negative)

**Tests:** 17 total
- [TemperatureConverterTest.java](src/test/java/com/example/calculatorservice/service/TemperatureConverterTest.java) - 17 comprehensive tests

**Why Practice This:**
- Double precision (not int)
- Mathematical formulas
- Boolean return types
- Real-world science application

---

## 📚 Study Materials (All Complete!)

### Quick Reference
- **[QUICK_REFERENCE.md](QUICK_REFERENCE.md)** - 5-minute cheat sheet
  - Import statements
  - Test patterns
  - Common test values
  - Emergency templates

### Main Study Guides
- **[EXAM_PREPARATION_GUIDE.md](EXAM_PREPARATION_GUIDE.md)** - How to score full marks
  - Detailed scoring strategy
  - Sample exam answers
  - Time management
  - Common mistakes

- **[TESTING_GUIDE.md](TESTING_GUIDE.md)** - Technical documentation
  - Requirements writing
  - Design reasoning
  - Testing strategy
  - JUnit best practices

### Templates & Examples
- **[TEST_TEMPLATES.md](TEST_TEMPLATES.md)** - Copy-paste ready templates
  - Basic test structure
  - Exception tests
  - Complete test class
  - Individual examples

### Practice Materials
- **[PRACTICE_EXAM.md](PRACTICE_EXAM.md)** - Full practice exam (StringUtility)
- **[PRACTICE_EXAM_SOLUTION.md](PRACTICE_EXAM_SOLUTION.md)** - Perfect answer
- **[ADDITIONAL_PRACTICE_SCENARIOS.md](ADDITIONAL_PRACTICE_SCENARIOS.md)** - 7 more scenarios!

---

## 🎨 Additional Practice Scenarios

[ADDITIONAL_PRACTICE_SCENARIOS.md](ADDITIONAL_PRACTICE_SCENARIOS.md) contains **7 complete scenarios**:

1. **Temperature Converter** 🌡️ (NOW IMPLEMENTED!)
   - Doubles, formulas, validation
   - 17 tests provided
   - Ready to run!

2. **Shopping Cart** 🛒
   - Financial calculations
   - Percentage operations
   - Range validation

3. **Date Validator** 📅
   - Complex business logic
   - Leap year rules
   - Parameter interdependency

4. **Password Validator** 🔐
   - String analysis
   - Character type checking
   - Multiple validation rules

5. **Array Utility** 📊
   - Array operations
   - Null/empty handling
   - Search algorithms

6. **Grade Calculator** 📚
   - Range-based logic
   - Array averaging
   - Letter grade conversion

7. **Number Utility** 🔢
   - Algorithms (prime, factorial)
   - Mathematical operations
   - Loop logic

**Each scenario includes:**
- ✅ Complete method specifications
- ✅ Test cases to implement
- ✅ Why it's good practice
- ✅ Common edge cases
- ✅ Implementation hints

---

## 📈 Test Coverage Summary

| Service | Basic Tests | Edge Cases | Exception Tests | Total | Status |
|---------|-------------|------------|-----------------|-------|--------|
| **Calculator** | 5 | 22 | 5 | **32** | ✅ All Pass |
| **StringUtility** | 12 | 3 | 1 | **16** | ✅ All Pass |
| **TemperatureConverter** | 12 | 4 | 1 | **17** | ✅ All Pass |
| **TOTAL** | | | | **65** | ✅ All Pass |

```
Tests run: 65, Failures: 0, Errors: 0, Skipped: 0
BUILD SUCCESS
```

---

## 🎓 Your Study Plan

### Tonight (2-3 hours)

**Hour 1: Practice Exam**
1. Take the StringUtility practice exam (60 min)
   - [PRACTICE_EXAM.md](PRACTICE_EXAM.md)
2. Check your answer (10 min)
   - [PRACTICE_EXAM_SOLUTION.md](PRACTICE_EXAM_SOLUTION.md)

**Hour 2: Review Implementations**
1. Study CalculatorService tests (20 min)
   - [CalculatorServiceComprehensiveTest.java](src/test/java/com/example/calculatorservice/service/CalculatorServiceComprehensiveTest.java)
2. Study StringUtility tests (20 min)
   - [StringUtilityTest.java](src/test/java/com/example/calculatorservice/service/StringUtilityTest.java)
3. Study TemperatureConverter tests (20 min)
   - [TemperatureConverterTest.java](src/test/java/com/example/calculatorservice/service/TemperatureConverterTest.java)

**Hour 3: Additional Practice (Optional)**
1. Pick 1-2 scenarios from [ADDITIONAL_PRACTICE_SCENARIOS.md](ADDITIONAL_PRACTICE_SCENARIOS.md)
2. Try implementing them yourself
3. Focus on the ones most different from Calculator:
   - Shopping Cart (financial calculations)
   - Password Validator (string analysis)
   - Number Utility (algorithms)

### Tomorrow Morning (15 minutes)

1. **Review [QUICK_REFERENCE.md](QUICK_REFERENCE.md)** (5 min)
   - Memorize import statements
   - Review test patterns
   - Check common mistakes

2. **Mental Practice** (5 min)
   - Imagine writing a test from scratch
   - Practice explaining design decisions
   - Think through edge cases

3. **Confidence Boost** (5 min)
   - Run `mvn test` to see 65 tests pass!
   - Remember: You have 3 complete implementations
   - You know the patterns!

### During The Exam

**Have Ready:**
- [QUICK_REFERENCE.md](QUICK_REFERENCE.md) - For patterns
- [TEST_TEMPLATES.md](TEST_TEMPLATES.md) - For copy-paste

**Remember:**
1. **Read carefully** - What data types? What exceptions?
2. **Plan first** - Write requirements before coding
3. **Test thoroughly** - 3+ tests per method
4. **Explain everything** - Show your reasoning
5. **Cover edge cases** - Zero, null, negative, empty

---

## 🔑 Key Patterns to Memorize

### Test Structure (AAA Pattern)
```java
@Test
public void testMethod_Scenario_ExpectedResult() {
    // Arrange: Set up test data
    ServiceClass service = new ServiceClass();
    DataType input = value;
    DataType expected = expectedValue;

    // Act: Execute the method
    DataType result = service.method(input);

    // Assert: Verify the result
    assertEquals(expected, result, "Description");
}
```

### Exception Test
```java
@Test
public void testMethod_InvalidInput_ThrowsException() {
    ServiceClass service = new ServiceClass();

    IllegalArgumentException exception = assertThrows(
        IllegalArgumentException.class,
        () -> service.method(invalidInput)
    );

    assertEquals("Expected message", exception.getMessage());
}
```

### Essential Imports
```java
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
```

---

## 💡 What Makes Each Example Unique

### Calculator Service - Best for:
- ✅ Integer arithmetic
- ✅ Basic exception handling
- ✅ Simple, clear operations
- ✅ **Most like typical exam questions**

### String Utility - Best for:
- ✅ String manipulation
- ✅ Null handling
- ✅ Different return types
- ✅ Character-level operations

### Temperature Converter - Best for:
- ✅ Double precision numbers
- ✅ Mathematical formulas
- ✅ Boolean validation
- ✅ Scientific/real-world context
- ✅ Tolerance in assertions (±0.01)

---

## 🎯 Different Test Techniques You've Learned

### 1. Integer Assertions (Calculator)
```java
assertEquals(8, calculator.add(3, 5));
```

### 2. String Assertions (StringUtility)
```java
assertEquals("HELLO", stringUtil.toUpperCase("hello"));
```

### 3. Double Assertions with Tolerance (Temperature)
```java
assertEquals(32.0, converter.celsiusToFahrenheit(0.0), 0.01);
```
*Note: The 0.01 is the tolerance for floating-point comparison*

### 4. Boolean Assertions (Temperature, validation)
```java
assertTrue(converter.isValidCelsius(20.0));
assertFalse(converter.isValidCelsius(-300.0));
```

### 5. Exception Assertions (All services)
```java
assertThrows(IllegalArgumentException.class,
    () -> service.method(invalidInput));
```

---

## 🔍 Common Edge Cases Across All Examples

| Category | Examples | Why Important |
|----------|----------|---------------|
| **Zero** | 0, 0.0, "" | Often special case |
| **Null** | null strings, null arrays | Should throw exception |
| **Negative** | -1, -100, -273.15 | May be invalid |
| **Boundary** | Min/max values, -40°C=-40°F | Test limits |
| **Empty** | "", empty array | Common real-world case |
| **Single** | "A", [1], 1.0 | Minimum valid input |
| **Same** | 5-5=0, "A"→"A" | Identity operations |

---

## 📝 Design Reasoning (Copy for ANY Service)

**Why @Service?**
- Marks class as Spring service component
- Enables dependency injection
- Allows autowiring into other components
- Follows Spring best practices

**Why Stateless Methods?**
- Thread-safe by design
- No instance variables to manage
- Easier to test
- More predictable behavior

**Why IllegalArgumentException?**
- Used for invalid method arguments
- Indicates programming error
- Runtime exception (unchecked)
- Clear, descriptive error messages

---

## 🚀 Run All Tests

```bash
# Run everything (65 tests)
mvn test

# Run specific service
mvn test -Dtest=CalculatorServiceTest
mvn test -Dtest=StringUtilityTest
mvn test -Dtest=TemperatureConverterTest

# Run comprehensive tests only
mvn test -Dtest=CalculatorServiceComprehensiveTest
```

---

## 🎁 Bonus: What You Can Do With This

### For Practice:
1. **Modify values** in existing tests
2. **Add more tests** to any service
3. **Implement** any of the 7 additional scenarios
4. **Mix and match** techniques across services

### For Learning:
1. **Compare** how different data types are tested
2. **Study** edge case patterns
3. **Understand** exception handling approaches
4. **Analyze** test value choices

### For Your Exam:
1. **Reference** test patterns
2. **Copy** template structures
3. **Adapt** reasoning explanations
4. **Reuse** design justifications

---

## ✨ Final Checklist

Before your exam, make sure you can:

- [ ] Write import statements from memory
- [ ] Explain why to use @Service
- [ ] Write a basic test using AAA pattern
- [ ] Write an exception test with assertThrows
- [ ] List 3 edge cases for any operation
- [ ] Explain why IllegalArgumentException is used
- [ ] Write user stories and acceptance criteria
- [ ] Use assertEquals with proper parameter order
- [ ] Handle both int and double assertions
- [ ] Explain your test value choices

---

## 🎊 You're Completely Ready!

**What you have:**
- ✅ 3 complete, working implementations
- ✅ 65 comprehensive tests
- ✅ 7 additional practice scenarios
- ✅ 5 detailed study guides
- ✅ Templates for every pattern
- ✅ Full practice exam with perfect solution

**What you know:**
- ✅ How to write tests (AAA pattern)
- ✅ How to test exceptions (assertThrows)
- ✅ How to handle edge cases
- ✅ How to explain design decisions
- ✅ How to score full marks

**You've got this!** 🎓✨

---

## 📞 Quick Help During Study

**Stuck on...** | **Check...**
----------------|-------------
What to test? | [QUICK_REFERENCE.md](QUICK_REFERENCE.md) - Test Values Cheat Sheet
How to write test? | [TEST_TEMPLATES.md](TEST_TEMPLATES.md) - Templates
Design reasoning? | [TESTING_GUIDE.md](TESTING_GUIDE.md) - Implementation Design
Exception handling? | [TemperatureConverterTest.java](src/test/java/com/example/calculatorservice/service/TemperatureConverterTest.java):128
Double assertions? | [TemperatureConverterTest.java](src/test/java/com/example/calculatorservice/service/TemperatureConverterTest.java):32
String tests? | [StringUtilityTest.java](src/test/java/com/example/calculatorservice/service/StringUtilityTest.java)
Full example? | [PRACTICE_EXAM_SOLUTION.md](PRACTICE_EXAM_SOLUTION.md)

Good luck on your exam! 🚀
