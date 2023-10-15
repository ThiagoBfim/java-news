package com.bomfim.java16;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class NewsStreamTest {

    @Test
    void toListStream() {
        List<Integer> integers = new NewsStream().toListStream(1, 2, 3, 4);
        Assertions.assertThat(integers).containsExactly(1, 2, 3, 4);
    }
}