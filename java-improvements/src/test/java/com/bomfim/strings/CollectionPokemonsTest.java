package com.bomfim.strings;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;

class CollectionPokemonsTest {

    private CollectionPokemons collectionPokemons;
    @BeforeEach
    void setUp() {
        collectionPokemons = new CollectionPokemons();
    }

    @Test
    void testGetLastOld() {
        CollectionPokemons.Pokemon lastPokemon = collectionPokemons.getLastOld(List.of(
                new CollectionPokemons.Pokemon("Pikachu"),
                new CollectionPokemons.Pokemon("Mewtwo"))
        );
        Assertions.assertThat(lastPokemon.name()).isEqualTo("Mewtwo");
    }

    @Test
    void testGetLastOldEmptyListShouldThrowException() {
        Assertions.assertThatThrownBy(() -> collectionPokemons.getLastOld(List.of()))
                .isInstanceOf(ArrayIndexOutOfBoundsException.class);
    }

    @Test
    void testGetLast() {
        CollectionPokemons.Pokemon lastPokemon = collectionPokemons.getLast(List.of(
                new CollectionPokemons.Pokemon("Pikachu"),
                new CollectionPokemons.Pokemon("Mewtwo"))
        );
        Assertions.assertThat(lastPokemon.name()).isEqualTo("Mewtwo");
    }
    @Test
    void testGetLastEmptyListShouldThrowException() {
        Assertions.assertThatThrownBy(() -> collectionPokemons.getLast(List.of()))
                .isInstanceOf(NoSuchElementException.class);
    }
}