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

    public String printToStringUpperWhenLenghtMoreThan10(Object object) {
        return switch (object) {
            case null -> "";
            case String s
                when s.length() > 10 -> s.toUpperCase();
            case String s -> s;
            default -> "not defined";
        };
    }

    public String printPokemonName(Object object) {
        return switch (object) {
            case null -> "";
            case RecordPatterns2Preview.Pokemon(String name, String type) -> name;
            default -> "not defined";
        };
    }
}
