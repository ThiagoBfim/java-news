package com.bomfim.java20;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RecordPatterns2PreviewTest {

    @Test
    void getPokemonName() {
        var pokemon = new RecordPatterns2Preview.Pokemon("Charizard", "Fire");
        String pokemonName = new RecordPatterns2Preview().getPokemonName(pokemon);
        Assertions.assertThat(pokemonName).isEqualTo("Charizard");
    }
}