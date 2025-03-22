package com.bomfim.improvements;

import com.bomfim.improvements.PokemonRecordPattern.Pokeball;
import com.bomfim.improvements.RecordPokemon.PokemonRecord;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PokemonRecordPatternTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;
    private PokemonRecordPattern pokemonRecordPattern;
    private PokemonRecord pokemon;
    private Pokeball pokeball;

    @BeforeEach
    void setUp() {
        pokemonRecordPattern = new PokemonRecordPattern();
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        pokemon = new PokemonRecord(1, "Bulbasaur", List.of("Grass", "Poison"), "Seed Pokémon");
        pokeball = new Pokeball("Ultra Ball", pokemon);

    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    void printPokemon() {
        pokemonRecordPattern.printPokemon(pokemon);
        assertThat(outContent.toString()).contains("Bulbasaur")
                .contains("1");
    }

    @Test
    void printPokemon2() {
        pokemonRecordPattern.printPokemon2(pokemon);
        assertThat(outContent.toString()).contains("Bulbasaur")
                .contains("1");
    }

    @Test
    void printPokeball() {
        pokemonRecordPattern.printPokeball(pokeball);
        assertThat(outContent.toString()).contains("Ultra Ball")
                .doesNotContain("Bulbasaur");
    }

    @Test
    void printPokeball2() {
        pokemonRecordPattern.printPokeball2(pokeball);
        assertThat(outContent.toString()).contains("Ultra Ball")
                .contains("Bulbasaur");
    }

    @Test
    void printPokeball2Old() {
        pokemonRecordPattern.printPokeball2Old(pokeball);
        assertThat(outContent.toString()).contains("Ultra Ball")
                .contains("Bulbasaur");
    }

    @Test
    void printPokeball2OldNPE() {
        var pokeballEmpty = new Pokeball("Ultra Ball", null);
        assertThatThrownBy(() -> pokemonRecordPattern.printPokeball2OldNPE(pokeballEmpty))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("Cannot invoke \"com.bomfim.improvements.RecordPokemon$PokemonRecord.name()\" because \"pokeball.pokemon\" is null");
    }

    @Test
    void printPokeball3() {
        pokemonRecordPattern.printPokeball3(pokeball);
        assertThat(outContent.toString()).contains("Ultra Ball")
                .contains("Bulbasaur");
    }

    @Test
    void printPokeball3WithoutPokemon() {
        var pokeballEmpty = new Pokeball("Ultra Ball", null);
        pokemonRecordPattern.printPokeball3(pokeballEmpty);
        assertThat(outContent.toString()).isEmpty();
    }
    @Test
    void printPokeball4WithoutPokemon() {
        var pokeballEmpty = new Pokeball("Ultra Ball", null);
        pokemonRecordPattern.printPokeball4(pokeballEmpty);
        assertThat(outContent.toString()).isEmpty();
    }
}