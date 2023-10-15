package com.bomfim.java21;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class StringImprovementsTest {

    @Test
    void testIndexOfRange() {
        int index = new StringImprovements().indexOfRangeAfter5Character("abcdeabcde");
        Assertions.assertThat(index).isEqualTo(5);
    }

    @Test
    void testSplitWithDelimiters() {
        String[] strings = new StringImprovements().splitWithDelimiters("Sao Paulo;Lisbon;Brasilia", "Lisbon");
        Assertions.assertThat(strings)
                .contains("Sao Paulo;")
                .contains("Lisbon")
                .contains(";Brasilia");
    }

    @Test
    void testSplitWithDelimitersPattern() {
        StringImprovements.City city = new StringImprovements().splitWithDelimitersPattern("1;Lisbon;504 718");
        Assertions.assertThat(city)
                .extracting(StringImprovements.City::index,
                        StringImprovements.City::city,
                        StringImprovements.City::population
                )
                .containsExactly(1, "Lisbon", "504 718");
    }
}