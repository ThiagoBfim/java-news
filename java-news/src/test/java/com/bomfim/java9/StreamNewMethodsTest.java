package com.bomfim.java9;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class StreamNewMethodsTest {

    @Test
    void shouldReturnNumbersBiggerThanFour() {
        long biggerThanFour = new StreamNewMethods().getNumbersBiggerThanFour(10);
        Assertions.assertThat(biggerThanFour).isEqualTo(6);
    }

    @Test
    void shouldReturnNumbersSmallerThanFour() {
        long biggerThanFour = new StreamNewMethods().getNumbersSmallerThanFour(10);
        Assertions.assertThat(biggerThanFour).isEqualTo(4);
    }

    @Test
    void shouldReturnZeroBecauseFirstNumberIsOdd() {
        long numbersPairsBeforeFirstOdd = new StreamNewMethods().countThePairsNumbersInTheBeginningOfTheStream(10);
        Assertions.assertThat(numbersPairsBeforeFirstOdd).isEqualTo(0);
    }
}