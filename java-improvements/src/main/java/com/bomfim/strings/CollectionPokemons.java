package com.bomfim.strings;

import java.util.List;

public class CollectionPokemons {

    public Pokemon getLastOld(List<Pokemon> pokemons) {
        return pokemons.get(pokemons.size() - 1);
    }

    /**
     * Using Sequenced Collections: JEP 431: Sequenced Collections
     * From java 21
     *
     * @param pokemons list of pokemons.
     * @return Last Pokemon
     */
    public Pokemon getLast(List<Pokemon> pokemons) {
        return pokemons.getLast();
    }

    public record Pokemon(String name) {
    }

}
