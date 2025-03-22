package com.bomfim.java22;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class StreamGatherersTestFinal {

    @Test
    void getMaxSumOfConsecutiveElements() {
        StreamGatherers streamGatherers = new StreamGatherers();
        Assertions.assertThat(streamGatherers.getMaxSumOfConsecutiveElements(List.of(100, 200, 300, 400), 2))
                .contains(300, 400);
        Assertions.assertThat(streamGatherers.getMaxSumOfConsecutiveElements(List.of(1, 4, 2, 10, 23, 3, 1, 0, 20), 4))
                .contains(4, 2, 10, 23);
    }
}