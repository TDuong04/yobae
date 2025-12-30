package com.example.calculatorservice;

import org.junit.jupiter.api.Test;

import com.example.calculatorservice.service.CalculatorService;
import com.example.calculatorservice.service.StringUtility;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class test {

    StringUtility stringUtility;
    @BeforeEach
    public void setUp() {
        stringUtility = new StringUtility();
    }

    @Test
    public void concatenate() {
        String a = "con";
        String b = "cac";

        String test = stringUtility.concatenate(a, b);
        assertEquals("concac", test,
            "Concatenating 'Hello' and 'World' should produce 'HelloWorld'");
        
    }
    
}
