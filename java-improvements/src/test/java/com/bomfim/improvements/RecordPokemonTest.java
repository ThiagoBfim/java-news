package com.bomfim.improvements;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class RecordPokemonTest {

    @Test
    void shouldReturnFalseIfEqualsWasNotImplementedWhenPokemonClassIsUsed() {
        var pikachu1 = new RecordPokemon.Pokemon(1, "Pikachu", List.of(), "Mouse Pokémon");
        var pikachu2 = new RecordPokemon.Pokemon(1, "Pikachu", List.of(), "Mouse Pokémon");
        Assertions.assertThat(pikachu1).isNotEqualTo(pikachu2);
        Assertions.assertThat(RecordPokemon.Pokemon.class).isFinal();
    }

    @Test
    void shouldReturnTrueWhenRecordPokemonIsUsed() {
        var pikachu1 = new RecordPokemon.PokemonRecord(1, "Pikachu", List.of(), "Mouse Pokémon");
        var pikachu2 = new RecordPokemon.PokemonRecord(1, "Pikachu", List.of(), "Mouse Pokémon");
        Assertions.assertThat(pikachu1).isEqualTo(pikachu2);
        Assertions.assertThat(RecordPokemon.PokemonRecord.class).isFinal();
    }
}