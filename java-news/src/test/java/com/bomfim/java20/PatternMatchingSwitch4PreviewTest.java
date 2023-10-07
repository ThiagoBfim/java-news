package com.bomfim.java20;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PatternMatchingSwitch4PreviewTest {

    @Test
    void printToString() {
        var patternMatchingSwitch = new PatternMatchingSwitch4Preview();
        assertThat(patternMatchingSwitch.printToString(null)).isEmpty();
        assertThat(patternMatchingSwitch.printToString("square")).isEqualTo("square");
        assertThat(patternMatchingSwitch.printToString(0.05)).isEqualTo("0.05");
        assertThat(patternMatchingSwitch.printToString(1)).isEqualTo("not defined");
    }

    @Test
    void printToStringUpperWhenLenghtMoreThan10() {
        var patternMatchingSwitch = new PatternMatchingSwitch4Preview();
        assertThat(patternMatchingSwitch.printToStringUpperWhenLengthMoreThan10(null)).isEmpty();
        assertThat(patternMatchingSwitch.printToStringUpperWhenLengthMoreThan10("square with more than 10")).isEqualTo("SQUARE WITH MORE THAN 10");
        assertThat(patternMatchingSwitch.printToStringUpperWhenLengthMoreThan10("square")).isEqualTo("square");
    }

    @Test
    void getPokemonName() {
        var pokemon = new RecordPatterns2Preview.Pokemon("Charizard", "Fire");
        String pokemonName = new PatternMatchingSwitch4Preview().printPokemonName(pokemon);
        Assertions.assertThat(pokemonName).isEqualTo("Charizard");
    }
}