package com.bomfim.java20;

/**
 * <a href="https://openjdk.org/jeps/432">JEP 432: Record Patterns (Second Preview)</a>
 */
public class RecordPatterns2Preview {

    public record Pokemon(String name, String type){};

    public String getPokemonName(Object object) {
        if(object instanceof Pokemon(String name, String type)){
            return name;
        }
        return "";
    }

}
