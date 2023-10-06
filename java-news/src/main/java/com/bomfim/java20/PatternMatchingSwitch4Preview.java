package com.bomfim.java20;

/**
 * <a href="https://openjdk.org/jeps/433">JEP 433: Pattern Matching for switch (Fourth Preview)</a>
 */
public class PatternMatchingSwitch4Preview {


    public String printToString(Object object) {
        return switch (object) {
            case null -> "";
            case String s -> s;
            case Double s -> s.toString();
            default -> "not defined";
        };
    }
}
