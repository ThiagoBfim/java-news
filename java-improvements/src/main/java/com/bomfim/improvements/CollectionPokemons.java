package com.bomfim.improvements;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Gatherers;
import java.util.stream.IntStream;

public class CollectionPokemons {

    public Pokemon getLastOld(List<Pokemon> pokemons) {
        if (pokemons.isEmpty()) {
            throw new NoSuchElementException();
        }
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

    public static List<List<Pokemon>> chunkListOld(List<Pokemon> list, int chunkSize) {
        List<List<Pokemon>> result = new ArrayList<>();
        int size = list.size();
        int chunks = (size + chunkSize - 1) / chunkSize;
        for (int i = 0; i < chunks; i++) {
            int start = i * chunkSize;
            int end = Math.min(size, (i + 1) * chunkSize);
            result.add(list.subList(start, end));
        }
        return result;
    }

    public List<List<Pokemon>> chunkList(List<Pokemon> list, int chunkSize) {
        int chunks = (list.size() + chunkSize - 1) / chunkSize;

        return IntStream.range(0, chunks)
                .mapToObj(i -> list.subList(i * chunkSize,
                        Math.min(list.size(), (i + 1) * chunkSize)))
                .toList();
    }

    public List<List<Pokemon>> chunkListGather(List<Pokemon> pokemons, int chunkSize) {
        return pokemons.stream()
                .gather(Gatherers.windowFixed(chunkSize))
                .toList();
    }

    record DistinctByLength(Pokemon pokemon) {

        @Override
        public boolean equals(Object obj) {
            return obj instanceof DistinctByLength(Pokemon other)
                    && pokemon.name.length() == other.name.length();
        }

        @Override
        public int hashCode() {
            return pokemon.name == null ? 0 : Integer.hashCode(pokemon.name.length());
        }

    }

}
