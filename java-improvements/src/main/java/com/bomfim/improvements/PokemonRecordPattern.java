package com.bomfim.improvements;

import com.bomfim.improvements.RecordPokemon.PokemonRecord;

import java.util.List;

public class PokemonRecordPattern {

    public record Pokeball(String name, PokemonRecord pokemon) {
    }

    public void printPokemon(Object obj) {
        if (obj instanceof PokemonRecord p) {
            int id = p.id();
            String name = p.name();
            System.out.println("name: " + name + "id: " + id);
        }
    }

    public void printPokemon2(Object obj) {
        if (obj instanceof PokemonRecord(Integer id, String name, List<String> type, String species)) {
            System.out.println("name: " + name + "id: " + id);
        }
    }

    public void printPokeball(Object obj) {
        if (obj instanceof Pokeball(String name, PokemonRecord pokemon)) {
            System.out.println("name: " + name);
        }
    }

    /**
     * Record Patterns - JEP 440: Record Patterns
     * From Java 21
     *
     * @param obj pokeball
     */
    public void printPokeball2(Object obj) {
        if (obj instanceof Pokeball(
                String name, PokemonRecord(Integer id, String pokemonName, List<String> type, String species))) {
            System.out.println("name: " + name + " - Pokemon: " + pokemonName);
        }
    }

    public void printPokeball2Old(Object obj) {
        if (obj instanceof Pokeball) {
            var pokeball = ((Pokeball) obj);
            var pokemon = pokeball.pokemon();
            if (pokemon != null) {
                System.out.println("name: " + pokeball.name + " - Pokemon: " + pokemon.name());
            }
        }
    }

    /**
     * Helpful NullPointerExceptions - JEP 358: Helpful NullPointerExceptions
     * From Java 14
     *
     * @param obj pokeball
     */
    public void printPokeball2OldNPE(Object obj) {
        if (obj instanceof Pokeball) {
            var pokeball = ((Pokeball) obj);
            System.out.println("name: " + pokeball.name + " - Pokemon: " + pokeball.pokemon.name());
        }
    }

    /**
     * Unnamed Patterns and Variables - JEP 286: Local-Variable Type Inference
     * From Java 10
     *
     * @param obj pokeball
     */
    public void printPokeball3(Object obj) {
        if (obj instanceof Pokeball(var name, PokemonRecord(var id, var pokemonName, var type, var species))) {
            System.out.println("name: " + name + " - Pokemon: " + pokemonName);
        }
    }

    /**
     * Unnamed Patterns and Variables - JEP 443: Unnamed Patterns and Variables (Preview)
     * From Java 21
     *
     * @param obj pokeball
     */
    public void printPokeball4(Object obj) {
        if (obj instanceof Pokeball(var name, PokemonRecord(_, var pokemonName, _, _))) {
            System.out.println("name: " + name + " - Pokemon: " + pokemonName);
        }
    }

}
