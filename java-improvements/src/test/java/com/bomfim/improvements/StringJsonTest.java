package com.bomfim.improvements;

import com.bomfim.improvements.RecordPokemon.PokemonRecord;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;


class StringJsonTest {

    private StringJson stringJson;
    private PokemonRecord pokemon;

    @BeforeEach
    void setUp() {
        stringJson = new StringJson();
        pokemon = new PokemonRecord(1, "Bulbasaur", List.of("Grass", "Poison"), "Seed Pokémon");
    }
    @Test
    void writeJson() {
        Assertions.assertThat(stringJson.writeJson(pokemon))
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

    @Test
    void writeJsonBuilder() {
        Assertions.assertThat(stringJson.writeJsonBuilder(pokemon))
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

    @Test
    void writeJsonTextBlock() {
        Assertions.assertThat(stringJson.writeJsonTextBlock(pokemon))
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

//    @Test
//    void writePokemonStringTemplate() {
//        Assertions.assertThat(stringJson.writePokemonStringTemplate(pokemon))
//                .isEqualTo("""
//                        {
//                          "id": 1,
//                          "name": "Bulbasaur",
//                          "type": [
//                            "Grass","Poison"
//                          ],
//                          "species": "Seed Pokémon",
//                        }
//                        """);
//    }
}