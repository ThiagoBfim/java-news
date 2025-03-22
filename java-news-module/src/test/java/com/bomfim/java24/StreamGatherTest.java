package com.bomfim.java24;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class StreamGatherTest {

    @Test
    void testGetValuesUntilOddNumber() {
        StreamGatherFinal streamGatherFinal = new StreamGatherFinal();
        Assertions.assertThat(streamGatherFinal.getValuesUntilOddNumber(List.of(1, 2, 3, 4, 5))).isEmpty();
        Assertions.assertThat(streamGatherFinal.getValuesUntilOddNumber(List.of(2, 4, 5, 6))).containsExactly(2, 4);
    }
}