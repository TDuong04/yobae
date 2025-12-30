# Additional Practice Scenarios for JUnit Exam

These are other common scenarios that might appear on your exam. Each follows the same format and grading criteria.

---

## Scenario 1: Temperature Converter Service 🌡️

### Problem Statement
Create a `TemperatureConverter` service that converts between Celsius and Fahrenheit.

### Methods to Implement:
1. **celsiusToFahrenheit(double celsius)** - Converts Celsius to Fahrenheit
   - Formula: F = (C × 9/5) + 32

2. **fahrenheitToCelsius(double fahrenheit)** - Converts Fahrenheit to Celsius
   - Formula: C = (F - 32) × 5/9

3. **isValidCelsius(double celsius)** - Checks if temperature is above absolute zero
   - Absolute zero: -273.15°C
   - Returns true if valid, false otherwise

4. **kelvinToCelsius(double kelvin)** - Converts Kelvin to Celsius
   - Formula: C = K - 273.15
   - Throws IllegalArgumentException if kelvin is negative

### Test Cases to Consider:
- **celsiusToFahrenheit:**
  - 0°C → 32°F (freezing point)
  - 100°C → 212°F (boiling point)
  - -40°C → -40°F (same value)
  - 37°C → 98.6°F (body temperature)

- **fahrenheitToCelsius:**
  - 32°F → 0°C
  - 212°F → 100°C
  - 98.6°F → 37°C

- **isValidCelsius:**
  - 0°C → true
  - -273.15°C → true (exactly absolute zero)
  - -300°C → false (below absolute zero)
  - 100°C → true

- **kelvinToCelsius:**
  - 273.15K → 0°C
  - 373.15K → 100°C
  - 0K → -273.15°C
  - -10K → Exception!

### Why This Tests:
- Working with doubles instead of ints
- Mathematical formulas
- Validation logic (boolean returns)
- Exception handling
- Real-world domain knowledge

---

## Scenario 2: Shopping Cart Service 🛒

### Problem Statement
Create a `ShoppingCart` service for basic cart operations.

### Methods to Implement:
1. **calculateTotal(double price, int quantity)** - Calculates total cost
   - Returns price × quantity

2. **applyDiscount(double total, double discountPercent)** - Applies discount
   - discountPercent is between 0 and 100
   - Returns total - (total × discountPercent / 100)
   - Throws IllegalArgumentException if discount < 0 or > 100

3. **calculateTax(double subtotal, double taxRate)** - Adds tax
   - taxRate is percentage (e.g., 8.5 for 8.5%)
   - Returns subtotal + (subtotal × taxRate / 100)

4. **isAffordable(double total, double budget)** - Checks if affordable
   - Returns true if total <= budget

### Test Cases to Consider:
- **calculateTotal:**
  - price=10.00, quantity=3 → 30.00
  - price=9.99, quantity=2 → 19.98
  - price=5.00, quantity=0 → 0.00
  - price=0.00, quantity=10 → 0.00

- **applyDiscount:**
  - total=100.00, discount=10% → 90.00
  - total=50.00, discount=0% → 50.00
  - total=100.00, discount=100% → 0.00
  - total=100.00, discount=-5% → Exception!
  - total=100.00, discount=150% → Exception!

- **calculateTax:**
  - subtotal=100.00, tax=8.5% → 108.50
  - subtotal=0.00, tax=10% → 0.00

- **isAffordable:**
  - total=50.00, budget=100.00 → true
  - total=100.00, budget=100.00 → true
  - total=100.01, budget=100.00 → false

### Why This Tests:
- Financial calculations with doubles
- Percentage calculations
- Range validation (0-100%)
- Multiple exception scenarios
- Comparison operations

---

## Scenario 3: Date Validator Service 📅

### Problem Statement
Create a `DateValidator` service to validate dates.

### Methods to Implement:
1. **isLeapYear(int year)** - Checks if year is a leap year
   - Leap year rules: divisible by 4, but not 100, unless also divisible by 400

2. **getDaysInMonth(int month, int year)** - Returns days in month
   - month is 1-12 (1=Jan, 12=Dec)
   - Accounts for leap years in February
   - Throws IllegalArgumentException if month < 1 or > 12

3. **isValidDate(int day, int month, int year)** - Validates date
   - Returns true if the date exists
   - Example: Feb 30 is invalid

4. **calculateAge(int birthYear, int currentYear)** - Calculates age
   - Returns currentYear - birthYear
   - Throws IllegalArgumentException if birthYear > currentYear

### Test Cases to Consider:
- **isLeapYear:**
  - 2000 → true (divisible by 400)
  - 2020 → true (divisible by 4, not 100)
  - 1900 → false (divisible by 100, not 400)
  - 2023 → false (not divisible by 4)

- **getDaysInMonth:**
  - month=1 (Jan), any year → 31
  - month=2 (Feb), year=2020 → 29 (leap year)
  - month=2 (Feb), year=2023 → 28 (not leap year)
  - month=4 (Apr), any year → 30
  - month=13, any year → Exception!

- **isValidDate:**
  - day=31, month=1, year=2023 → true
  - day=29, month=2, year=2020 → true (leap year)
  - day=29, month=2, year=2023 → false (not leap year)
  - day=31, month=4, year=2023 → false (April has 30 days)

- **calculateAge:**
  - birth=2000, current=2024 → 24
  - birth=2024, current=2024 → 0
  - birth=2025, current=2024 → Exception!

### Why This Tests:
- Complex business logic (leap year rules)
- Multiple conditions (nested if statements)
- Parameter interdependency (month + year)
- Range validation
- Integer arithmetic

---

## Scenario 4: Password Validator Service 🔐

### Problem Statement
Create a `PasswordValidator` service to validate passwords.

### Methods to Implement:
1. **isLengthValid(String password, int minLength)** - Checks minimum length
   - Returns true if password.length() >= minLength
   - Throws IllegalArgumentException if password is null

2. **hasDigit(String password)** - Checks if password contains a digit
   - Returns true if contains at least one digit (0-9)

3. **hasUpperCase(String password)** - Checks for uppercase letter
   - Returns true if contains at least one uppercase letter

4. **hasSpecialChar(String password)** - Checks for special character
   - Special chars: !@#$%^&*
   - Returns true if contains at least one

### Test Cases to Consider:
- **isLengthValid:**
  - password="Pass123!", minLength=8 → true
  - password="Pass", minLength=8 → false
  - password="Password", minLength=8 → true (exactly 8)
  - password=null, minLength=8 → Exception!

- **hasDigit:**
  - "Password1" → true
  - "password" → false
  - "Pass123" → true
  - "" → false

- **hasUpperCase:**
  - "Password" → true
  - "password" → false
  - "PASSWORD" → true
  - "pAssword" → true

- **hasSpecialChar:**
  - "Pass@123" → true
  - "Password123" → false
  - "P@ss#!" → true
  - "!@#$%" → true

### Why This Tests:
- String analysis
- Character type checking
- Null handling
- Boolean logic
- Real-world validation

---

## Scenario 5: Array Utility Service 📊

### Problem Statement
Create an `ArrayUtility` service for basic array operations.

### Methods to Implement:
1. **findMax(int[] numbers)** - Returns maximum value
   - Throws IllegalArgumentException if array is null or empty

2. **findMin(int[] numbers)** - Returns minimum value
   - Throws IllegalArgumentException if array is null or empty

3. **calculateAverage(int[] numbers)** - Returns average as double
   - Throws IllegalArgumentException if array is null or empty

4. **contains(int[] numbers, int target)** - Checks if array contains value
   - Returns true if found
   - Returns false if array is empty or null

### Test Cases to Consider:
- **findMax:**
  - [1, 5, 3, 9, 2] → 9
  - [5] → 5 (single element)
  - [-5, -1, -10] → -1 (all negative)
  - [] → Exception!
  - null → Exception!

- **findMin:**
  - [1, 5, 3, 9, 2] → 1
  - [5] → 5
  - [-5, -1, -10] → -10

- **calculateAverage:**
  - [1, 2, 3, 4, 5] → 3.0
  - [10] → 10.0
  - [2, 3] → 2.5

- **contains:**
  - [1, 2, 3], target=2 → true
  - [1, 2, 3], target=5 → false
  - [], target=1 → false
  - null, target=1 → false

### Why This Tests:
- Array operations
- Handling null and empty arrays
- Multiple exception scenarios
- Type conversion (int to double)
- Search algorithms

---

## Scenario 6: Grade Calculator Service 📚

### Problem Statement
Create a `GradeCalculator` service for student grades.

### Methods to Implement:
1. **calculateGPA(double[] grades)** - Calculates average GPA
   - Returns average of all grades
   - Throws IllegalArgumentException if array is null or empty

2. **getLetterGrade(double score)** - Converts score to letter
   - 90-100: "A"
   - 80-89: "B"
   - 70-79: "C"
   - 60-69: "D"
   - 0-59: "F"
   - Throws IllegalArgumentException if score < 0 or > 100

3. **isPassing(double score, double passingGrade)** - Checks if passing
   - Returns true if score >= passingGrade

4. **calculateWeightedScore(double score, double weight)** - Applies weight
   - weight is 0.0 to 1.0 (e.g., 0.3 for 30%)
   - Returns score × weight
   - Throws IllegalArgumentException if weight < 0 or > 1

### Test Cases to Consider:
- **calculateGPA:**
  - [90, 85, 92] → 89.0
  - [100] → 100.0
  - [70, 80, 90] → 80.0
  - [] → Exception!

- **getLetterGrade:**
  - 95 → "A"
  - 90 → "A" (boundary)
  - 89 → "B" (boundary)
  - 75 → "C"
  - 50 → "F"
  - -10 → Exception!
  - 110 → Exception!

- **isPassing:**
  - score=75, passing=70 → true
  - score=70, passing=70 → true
  - score=69, passing=70 → false

- **calculateWeightedScore:**
  - score=90, weight=0.3 → 27.0
  - score=100, weight=1.0 → 100.0
  - score=80, weight=0 → 0.0
  - score=90, weight=1.5 → Exception!

### Why This Tests:
- Range-based logic (if-else chains)
- Array averaging
- Boundary conditions
- Percentage/weight calculations
- String returns

---

## Scenario 7: Number Utility Service 🔢

### Problem Statement
Create a `NumberUtility` service for number operations.

### Methods to Implement:
1. **isEven(int number)** - Checks if number is even
   - Returns true if divisible by 2

2. **isPrime(int number)** - Checks if number is prime
   - Returns true if number is prime (only divisible by 1 and itself)
   - Returns false for numbers <= 1

3. **factorial(int n)** - Calculates factorial
   - Returns n! = n × (n-1) × ... × 1
   - Throws IllegalArgumentException if n < 0
   - 0! = 1

4. **power(int base, int exponent)** - Calculates power
   - Returns base^exponent
   - Throws IllegalArgumentException if exponent < 0

### Test Cases to Consider:
- **isEven:**
  - 4 → true
  - 7 → false
  - 0 → true
  - -2 → true
  - -3 → false

- **isPrime:**
  - 2 → true (smallest prime)
  - 3 → true
  - 4 → false
  - 17 → true
  - 1 → false
  - 0 → false
  - -5 → false

- **factorial:**
  - 5 → 120
  - 0 → 1 (special case)
  - 1 → 1
  - 3 → 6
  - -1 → Exception!

- **power:**
  - base=2, exp=3 → 8
  - base=5, exp=0 → 1
  - base=10, exp=2 → 100
  - base=2, exp=-1 → Exception!

### Why This Tests:
- Mathematical algorithms
- Edge cases (0, 1, negative)
- Loop logic
- Special case handling
- Multiple exception scenarios

---

## Common Patterns Across All Scenarios

### Exception Testing Patterns:
```java
// Null string
assertThrows(IllegalArgumentException.class,
    () -> service.method(null));

// Invalid range
assertThrows(IllegalArgumentException.class,
    () -> service.method(-1));

// Out of bounds
assertThrows(IllegalArgumentException.class,
    () -> service.method(1000));
```

### Edge Cases to Always Test:
- **Zero:** Often a special case
- **Empty:** Empty strings, empty arrays
- **Null:** Should usually throw exception
- **Negative:** Often invalid
- **Boundary values:** Min/max of valid ranges
- **Single element:** Arrays/strings with one item

### Design Reasoning (applies to all):
```
Why @Service?
- Spring dependency injection
- Component scanning
- Business logic layer

Why stateless methods?
- Thread-safe
- Easier to test
- No side effects

Why IllegalArgumentException?
- Invalid input from caller
- Programming error
- Runtime exception (unchecked)
```

---

## Quick Implementation Templates

### Boolean Method:
```java
public boolean isValid(int value) {
    return value >= 0 && value <= 100;
}
```

### Calculation Method:
```java
public double calculate(double a, double b) {
    return a * b;
}
```

### Validation with Exception:
```java
public int process(int value) {
    if (value < 0) {
        throw new IllegalArgumentException("Value must be non-negative");
    }
    return value * 2;
}
```

### String Analysis:
```java
public boolean hasCharacter(String str, char c) {
    if (str == null) {
        throw new IllegalArgumentException("String cannot be null");
    }
    return str.indexOf(c) >= 0;
}
```

---

## Practice Strategy

**Try These In Order:**
1. **Temperature Converter** - Good for doubles and formulas
2. **Shopping Cart** - Good for business logic
3. **Number Utility** - Good for algorithms
4. **Password Validator** - Good for string operations
5. **Date Validator** - Good for complex logic
6. **Grade Calculator** - Good for ranges and arrays
7. **Array Utility** - Good for null handling

**For Each Scenario:**
1. Write requirements (10 min)
2. Implement code (15 min)
3. Write tests (30 min)
4. Review and add reasoning (5 min)

---

## What Makes These Good Practice

✅ **Variety of data types:** int, double, String, boolean, arrays
✅ **Different return types:** primitives, objects, void
✅ **Various complexity levels:** simple to complex
✅ **Real-world scenarios:** Students can relate to these
✅ **Multiple exception cases:** Practice assertThrows
✅ **Edge cases galore:** Zero, null, empty, negative, boundaries
✅ **Different logic types:** Math, validation, analysis, search

Pick any scenario and practice the full exam process!
