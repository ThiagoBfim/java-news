package com.bomfim.java8;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ExampleStreamTest {

    @Test
    void shouldHave5PairsNumbersBetween1and10() {
        long pairsNumbers = new ExampleStream().countPairsNumbers(10);
        Assertions.assertThat(pairsNumbers).isEqualTo(5);
    }

    @Test
    void shouldCountPairsNumbersParallel() {
        //The system.out.println will not follow a sequence order because it's a parallelStream.
        long pairsNumbers = new ExampleStream().countPairsNumbersParallel(10);
        Assertions.assertThat(pairsNumbers).isEqualTo(5);
    }

    @Test
    void shouldThrowExceptionWhenCallFinalizedStream() {
        Assertions.assertThatThrownBy(() -> new ExampleStream().errorStream(10))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("stream has already been operated upon or closed");
    }
}