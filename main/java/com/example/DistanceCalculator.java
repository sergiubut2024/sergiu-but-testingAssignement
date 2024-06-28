// Path: /src/main/java/com/example/DistanceCalculator.java
package com.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DistanceCalculator {

    public static int convert_to_mm(int value, String unit) {
        switch (unit) {
            case "mm": return value;
            case "cm": return value * 10;
            case "dm": return value * 100;
            case "m": return value * 1000;
            case "km": return value * 1000000;
            default: throw new IllegalArgumentException("Unknown unit: " + unit);
        }
    }

    public static int evaluate_expression(String expression) {
        Pattern pattern = Pattern.compile("([+-]?\\d+\\s*(mm|cm|dm|m|km))");
        Matcher matcher = pattern.matcher(expression);

        int total = 0;

        while (matcher.find()) {
            String[] parts = matcher.group().split("\\s+");
            int value = Integer.parseInt(parts[0]);
            String unit = parts[1];
            total += convert_to_mm(value, unit);
        }

        return total;
    }

    public static void main(String[] args) {
        String expression = "10 cm + 1 m - 10 mm";
        int result = evaluate_expression(expression);
        System.out.println("Result: " + result + " mm");
    }
}
