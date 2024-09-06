package com.bomfim.improvements;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PokeballTest {

    @Test
    void testUltraBallHighLevel() {
        Assertions.assertThatThrownBy(() -> new Pokeball.Ultraball("Pikachu", 100))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("The level of Pokémon is too high for this Pokeball.");
    }

    @Test
    void testUltraBall() {
        new Pokeball
                .Ultraball("Pikachu", 60);
    }

    @Test
    void testUltraBallOldHighLevel() {
        Assertions.assertThatThrownBy(() -> new Pokeball.UltraballOld("Pikachu", 100))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("The level of Pokémon is too high for this Pokeball.");
    }

    @Test
    void testUltraBallOld() {
        new Pokeball
                .UltraballOld("Pikachu", 60);
    }
}