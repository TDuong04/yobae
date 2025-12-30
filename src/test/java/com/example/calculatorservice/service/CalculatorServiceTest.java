package com.example.calculatorservice.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorServiceTest {

    @Test
    public void testAdd() {
        CalculatorService calculatorService = new CalculatorService();
        int result = calculatorService.add(3, 5);
        assertEquals(8, result);
    }

    @Test
    public void testSubtract() {
        CalculatorService calculatorService = new CalculatorService();
        int result = calculatorService.subtract(10, 4);
        assertEquals(6, result);
    }

    @Test
    public void testMultiply() {
        CalculatorService calculatorService = new CalculatorService();
        int result = calculatorService.multiply(6, 7);
        assertEquals(42, result);
    }

    @Test
    public void testDivide() {
        CalculatorService calculatorService = new CalculatorService();
        int result = calculatorService.divide(20, 4);
        assertEquals(5, result);
    }

    @Test
    public void testDivideByZero() {
        CalculatorService calculatorService = new CalculatorService();
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> calculatorService.divide(10, 0)
        );
        assertEquals("Cannot divide by zero", exception.getMessage());
    }
}
