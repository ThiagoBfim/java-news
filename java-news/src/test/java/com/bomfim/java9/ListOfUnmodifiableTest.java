package com.bomfim.java9;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

class ListOfUnmodifiableTest {


    @Test
    void shouldCreateUnmodifiableList() {
        List<Integer> unmodifiableCopy = new OfUnmodifiable().createUnmodifiableList(1, 2, 3);
        Assertions.assertThat(unmodifiableCopy).hasSize(3);
    }

    @Test
    void shouldThrowExceptionWhenChangeTheNewUnmodifiableList() {
        List<Integer> unmodifiableCopy = new OfUnmodifiable().createUnmodifiableList(1, 2, 3);
        Assertions.assertThatThrownBy(() -> unmodifiableCopy.add(3))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void shouldCreateUnmodifiableSet() {
        Set<Integer> unmodifiableCopy = new OfUnmodifiable().createUnmodifiableSet(1, 2, 3);
        Assertions.assertThat(unmodifiableCopy).hasSize(3);
    }

    @Test
    void shouldThrowExceptionWhenChangeTheNewUnmodifiableSet() {
        Set<Integer> unmodifiableCopy = new OfUnmodifiable().createUnmodifiableSet(1, 2, 3);
        Assertions.assertThatThrownBy(() -> unmodifiableCopy.add(3))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void shouldCreateUnmodifiableMap() {
        Map<Integer, Integer> unmodifiableCopy = new OfUnmodifiable().createUnmodifiableMap(1, 1, 2, 2);
        Assertions.assertThat(unmodifiableCopy).containsEntry(1, 1);
        Assertions.assertThat(unmodifiableCopy).containsEntry(2, 2);
    }

    @Test
    void shouldThrowExceptionWhenChangeTheNewUnmodifiableMap() {
        Map<Integer, Integer> unmodifiableCopy = new OfUnmodifiable().createUnmodifiableMap(1, 1, 2, 2);
        Assertions.assertThatThrownBy(() -> unmodifiableCopy.put(3, 3))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}