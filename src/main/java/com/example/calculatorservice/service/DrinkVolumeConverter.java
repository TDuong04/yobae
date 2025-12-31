package com.example.calculatorservice.service;

import org.springframework.stereotype.Service;

/**
 * Drink Volume Converter Service
 *
 * Converts drink volumes between millilitres (mL) and cups.
 * Uses the conversion rate: 1 cup = 250 mL
 *
 * This service is designed for home bakers and cafe staff
 * who need to convert between metric and cup measurements.
 */
@Service
public class DrinkVolumeConverter {

    /**
     * Conversion constant: 1 cup = 250 millilitres
     */
    private static final double ML_PER_CUP = 250.0;

    /**
     * Converts millilitres to cups.
     * Formula: cups = mL / 250
     *
     * @param millilitres Volume in millilitres to convert
     * @return Volume in cups
     * @throws IllegalArgumentException if millilitres is negative
     */
    public double millilitresToCups(double millilitres) {
        if (millilitres < 0) {
            throw new IllegalArgumentException("Volume cannot be negative");
        }
        return millilitres / ML_PER_CUP;
    }

    /**
     * Converts cups to millilitres.
     * Formula: mL = cups × 250
     *
     * @param cups Volume in cups to convert
     * @return Volume in millilitres
     * @throws IllegalArgumentException if cups is negative
     */
    public double cupsToMillilitres(double cups) {
        if (cups < 0) {
            throw new IllegalArgumentException("Volume cannot be negative");
        }
        return cups * ML_PER_CUP;
    }
}
