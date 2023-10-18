package com.bomfim.java12;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TeeingCollectorTest {

    @Test
    void teeing() {
        String teeing = new TeeingCollector().minAndMaxValue(1, 1, 2, 3, 5, 8, 13);
        assertThat(teeing)
                .contains("Min - 1")
                .contains("Max - 13");
    }
}