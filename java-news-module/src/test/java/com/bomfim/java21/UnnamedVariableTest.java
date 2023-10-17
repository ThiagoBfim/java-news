package com.bomfim.java21;

import com.bomfim.java21.UnnamedVariable.Pokeball;
import com.bomfim.java21.UnnamedVariable.PokemonRecord;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class UnnamedVariableTest {

    @Test
    void testGetPokemonDetailsFromPokeballWithEmptyPokeball() {
        var pokeballEmpty = new Pokeball("Ultra Ball", null);
        String detailsFromPokeball = new UnnamedVariable().getPokemonDetailsFromPokeball(pokeballEmpty);
        assertThat(detailsFromPokeball).isNull();
    }

    @Test
    void testGetPokemonDetailsFromPokeballWithWrongObject() {
        String detailsFromPokeball = new UnnamedVariable().getPokemonDetailsFromPokeball("teste");
        assertThat(detailsFromPokeball).isNull();
    }

    @Test
    void getPokemonDetailsFromPokeball() {
        var pokemon = new PokemonRecord(1, "Bulbasaur", List.of("Grass", "Poison"), "Seed Pokémon");
        var pokeball = new Pokeball("Ultra Ball", pokemon);
        String detailsFromPokeball = new UnnamedVariable().getPokemonDetailsFromPokeball(pokeball);
        assertThat(detailsFromPokeball)
                .contains("Pokeball: Ultra Ball")
                .contains("Pokemon: Bulbasaur");

    }
}