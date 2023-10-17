package com.bomfim.java21;

import java.util.List;

public class UnnamedVariable {

    /**
     * Unnamed Patterns and Variables - JEP 443: Unnamed Patterns and Variables (Preview)
     * From Java 21
     *
     * @param obj pokeball
     * @return
     */
    public String getPokemonDetailsFromPokeball(Object obj) {
        if (obj instanceof Pokeball(String name, PokemonRecord(var _, String pokemonName, var _, var _))) {
            return "Pokeball: " + name + " - Pokemon: " + pokemonName;
        }
        return null;
    }

    record Pokeball(String name, PokemonRecord pokemonRecord) {
    }

    record PokemonRecord(Integer id, String pokemonName, List<String> type, String species) {
    }
}
