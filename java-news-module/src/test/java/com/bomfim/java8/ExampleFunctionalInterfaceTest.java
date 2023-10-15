package com.bomfim.java8;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.Arrays;

class ExampleFunctionalInterfaceTest {

    private ExampleFunctionalInterface exampleFunctionalInterface;

    @BeforeEach
    void setUp() {
        exampleFunctionalInterface = new ExampleFunctionalInterface(Arrays.asList("Amanda", "Jack", "Liam", "Jonny", "Oliver", "Emma", "Olivia"));
    }

    @Test
    void shouldCountConsumesCountFromPeekMethod() {
        long consumesCount = exampleFunctionalInterface.consumeNames(System.out::println);
        Assertions.assertThat(consumesCount).isEqualTo(7L);
    }

    @Test
    void shouldSumLettersFromNames() {
        long sumLetters = exampleFunctionalInterface.functionNames(String::length);
        Assertions.assertThat(sumLetters).isEqualTo(35L);
    }

    @Test
    void shouldFilterNamesWithLessOrEqualToThan5Letters() {
        long namesWithLessThanOrEqualTo5Letters = exampleFunctionalInterface.predicateNames(n -> n.length() <= 5);
        Assertions.assertThat(namesWithLessThanOrEqualTo5Letters).isEqualTo(4L);
    }

    @Test
    void shouldParseToString() {
        String ten = exampleFunctionalInterface.exampleNewFunctionalInterface(Object::toString, BigInteger.TEN);
        Assertions.assertThat(ten).isEqualTo("10");
    }
}