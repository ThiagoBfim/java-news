package com.bomfim.java10;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

class CopyUnmodifiableTest {

    @Test
    void shouldCreateUnmodifiableCopyList() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        List<Integer> unmodifiableCopy = new CopyUnmodifiable().createUnmodifiableCopy(numbers);
        numbers.add(3);
        Assertions.assertThat(unmodifiableCopy).hasSize(2);
        Assertions.assertThat(numbers).hasSize(3);
    }

    @Test
    void shouldThrowExceptionWhenChangeTheCopyUnmodifiableList() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        List<Integer> unmodifiableCopy = new CopyUnmodifiable().createUnmodifiableCopy(numbers);
        Assertions.assertThatThrownBy(() -> unmodifiableCopy.add(3))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void shouldCreateUnmodifiableCopySet() {
        Set<Integer> numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(2);
        Set<Integer> unmodifiableCopy = new CopyUnmodifiable().createUnmodifiableCopy(numbers);
        numbers.add(3);
        Assertions.assertThat(unmodifiableCopy).hasSize(2);
        Assertions.assertThat(numbers).hasSize(3);
    }

    @Test
    void shouldThrowExceptionWhenChangeTheCopyUnmodifiableSet() {
        Set<Integer> numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(2);
        Set<Integer> unmodifiableCopy = new CopyUnmodifiable().createUnmodifiableCopy(numbers);
        Assertions.assertThatThrownBy(() -> unmodifiableCopy.add(3))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void shouldCreateUnmodifiableCopyMap() {
        Map<Integer, Integer> numbers = new HashMap<>();
        numbers.put(1,1);
        numbers.put(2,2);
        Map<Integer, Integer> unmodifiableCopy = new CopyUnmodifiable().createUnmodifiableCopy(numbers);
        numbers.put(3,3);
        Assertions.assertThat(unmodifiableCopy).hasSize(2);
        Assertions.assertThat(numbers).hasSize(3);
    }

    @Test
    void shouldThrowExceptionWhenChangeTheCopyUnmodifiableMap() {
        Map<Integer, Integer> numbers = new HashMap<>();
        numbers.put(1,1);
        numbers.put(2,2);
        Map<Integer, Integer> unmodifiableCopy = new CopyUnmodifiable().createUnmodifiableCopy(numbers);
        Assertions.assertThatThrownBy(() -> unmodifiableCopy.put(3,3))
                .isInstanceOf(UnsupportedOperationException.class);
    }

}