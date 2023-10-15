package com.bomfim.java21;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class JsonStringTemplateTest {

    @Test
    void writePokemonStringTemplate() {
        var pokemon = new JsonStringTemplate.PokemonRecord(1, "Bulbasaur", List.of("Grass", "Poison"), "Seed Pokémon");
        Assertions.assertThat(new JsonStringTemplate().writePokemonStringTemplate(pokemon))
                .isEqualTo("""
                        {
                          "id": 1,
                          "name": "Bulbasaur",
                          "type": [
                            "Grass","Poison"
                          ],
                          "species": "Seed Pokémon",
                        }
                        """);
    }
}