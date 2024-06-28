// Path: /src/test/java/com/example/DistanceCalculatorTest.java
package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

public class DistanceCalculatorTest {

    @Test
    public void testConversionToMm() {
        assertEquals(10, DistanceCalculator.convert_to_mm(10, "mm"));
        assertEquals(100, DistanceCalculator.convert_to_mm(10, "cm"));
        assertEquals(1000, DistanceCalculator.convert_to_mm(10, "dm"));
        assertEquals(10000, DistanceCalculator.convert_to_mm(10, "m"));
        assertEquals(10000000, DistanceCalculator.convert_to_mm(10, "km"));
    }

    @Test
    public void testEvaluateExpression() {
        assertEquals(1090, DistanceCalculator.evaluate_expression("10 cm + 1 m - 10 mm"));
        assertEquals(2000, DistanceCalculator.evaluate_expression("2 m"));
        assertEquals(1000, DistanceCalculator.evaluate_expression("1 km - 999 m"));
    }

    @ParameterizedTest
    @CsvSource({
        "10 cm + 1 m - 10 mm, 1090",
        "2 m, 2000",
        "1 km - 999 m, 1000"
    })
    public void testEvaluateExpressionParameterized(String expression, int expected) {
        assertEquals(expected, DistanceCalculator.evaluate_expression(expression));
    }
}
