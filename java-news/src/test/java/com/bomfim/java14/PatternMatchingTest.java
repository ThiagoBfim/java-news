package com.bomfim.java14;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class PatternMatchingTest {

    @Test
    void shouldGetLength() {
        var patternMatching = new PatternMatching();
        Assertions.assertThat(patternMatching.getLength("123")).isEqualTo(3);
        Assertions.assertThat(patternMatching.getLength(123)).isEqualTo(123);
        Assertions.assertThat(patternMatching.getLength(123.33)).isEqualTo(123);
        Assertions.assertThat(patternMatching.getLength(List.of(1, 2, "3", "4"))).isEqualTo(4);
        Assertions.assertThat(patternMatching.getLength(new PatternMatching())).isEqualTo(0);
    }
}