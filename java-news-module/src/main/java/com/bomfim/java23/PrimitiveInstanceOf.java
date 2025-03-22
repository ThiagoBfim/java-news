package com.bomfim.java23;

/**
 * JEP 455: Primitive Types in Patterns, instanceof, and switch (Preview)
 *
 * https://openjdk.org/jeps/455
 */
public class PrimitiveInstanceOf {

    public String getAgeRange(int age) {
        return switch (age) {
            case 0 -> throw new IllegalArgumentException("Wrong Age");
            case int i when i <= 20 -> "KID";
            case int i when i >= 21 && i<=50 -> "ADULT";
            case int i when i >= 50 -> "OLDER";
            default -> "N/A";
        };
    }
}
