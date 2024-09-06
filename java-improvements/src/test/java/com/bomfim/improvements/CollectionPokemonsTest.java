package com.bomfim.improvements;

import com.bomfim.improvements.CollectionPokemons.Pokemon;
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
        Pokemon lastPokemon = collectionPokemons.getLastOld(List.of(
                new Pokemon("Pikachu"),
                new Pokemon("Mewtwo"))
        );
        Assertions.assertThat(lastPokemon.name()).isEqualTo("Mewtwo");
    }

    @Test
    void testGetLastOldEmptyListShouldThrowException() {
        Assertions.assertThatThrownBy(() -> collectionPokemons.getLastOld(List.of()))
                .isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void testGetLast() {
        Pokemon lastPokemon = collectionPokemons.getLast(List.of(
                new Pokemon("Pikachu"),
                new Pokemon("Mewtwo"))
        );
        Assertions.assertThat(lastPokemon.name()).isEqualTo("Mewtwo");
    }

    @Test
    void testGetLastEmptyListShouldThrowException() {
        Assertions.assertThatThrownBy(() -> collectionPokemons.getLast(List.of()))
                .isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void testGetPokemonsOldDistinctByNameLength() {
        Pokemon pikachu = new Pokemon("Pikachu");
        Pokemon charmander = new Pokemon("Charmander");
        Pokemon bulbasaur = new Pokemon("Bulbasaur");
        Pokemon squirtle = new Pokemon("Squirtle");
        Pokemon jigglypuff = new Pokemon("Jigglypuff");
        Pokemon eevee = new Pokemon("Eevee");
        Pokemon mewtwo = new Pokemon("Mewtwo");
        Pokemon gengar = new Pokemon("Gengar");
        List<Pokemon> pokemonList = List.of(
                pikachu,
                charmander,
                bulbasaur,
                squirtle,
                jigglypuff,
                eevee,
                mewtwo,
                gengar
        );
        List<List<Pokemon>> pokemons = collectionPokemons.chunkListOld(pokemonList, 3);
        Assertions.assertThat(pokemons.get(0)).containsOnly(pikachu, charmander, bulbasaur);
        Assertions.assertThat(pokemons.get(1)).containsOnly(squirtle, jigglypuff, eevee);
        Assertions.assertThat(pokemons.get(2)).containsOnly(mewtwo, gengar);
    }
    @Test
    void testGetPokemonsDistinctByNameLength() {
        Pokemon pikachu = new Pokemon("Pikachu");
        Pokemon charmander = new Pokemon("Charmander");
        Pokemon bulbasaur = new Pokemon("Bulbasaur");
        Pokemon squirtle = new Pokemon("Squirtle");
        Pokemon jigglypuff = new Pokemon("Jigglypuff");
        Pokemon eevee = new Pokemon("Eevee");
        Pokemon mewtwo = new Pokemon("Mewtwo");
        Pokemon gengar = new Pokemon("Gengar");
        List<Pokemon> pokemonList = List.of(
                pikachu,
                charmander,
                bulbasaur,
                squirtle,
                jigglypuff,
                eevee,
                mewtwo,
                gengar
        );
        List<List<Pokemon>> pokemons = collectionPokemons.chunkList(pokemonList, 3);
        Assertions.assertThat(pokemons.get(0)).containsOnly(pikachu, charmander, bulbasaur);
        Assertions.assertThat(pokemons.get(1)).containsOnly(squirtle, jigglypuff, eevee);
        Assertions.assertThat(pokemons.get(2)).containsOnly(mewtwo, gengar);
    }

    @Test
    void testGetPokemonsDistinctByNameLengthGather() {
        Pokemon pikachu = new Pokemon("Pikachu");
        Pokemon charmander = new Pokemon("Charmander");
        Pokemon bulbasaur = new Pokemon("Bulbasaur");
        Pokemon squirtle = new Pokemon("Squirtle");
        Pokemon jigglypuff = new Pokemon("Jigglypuff");
        Pokemon eevee = new Pokemon("Eevee");
        Pokemon mewtwo = new Pokemon("Mewtwo");
        Pokemon gengar = new Pokemon("Gengar");
        List<Pokemon> pokemonList = List.of(
                pikachu,
                charmander,
                bulbasaur,
                squirtle,
                jigglypuff,
                eevee,
                mewtwo,
                gengar
        );
        List<List<Pokemon>> pokemons = collectionPokemons.chunkListGather(pokemonList, 3);
        Assertions.assertThat(pokemons.get(0)).containsOnly(pikachu, charmander, bulbasaur);
        Assertions.assertThat(pokemons.get(1)).containsOnly(squirtle, jigglypuff, eevee);
        Assertions.assertThat(pokemons.get(2)).containsOnly(mewtwo, gengar);
    }
}