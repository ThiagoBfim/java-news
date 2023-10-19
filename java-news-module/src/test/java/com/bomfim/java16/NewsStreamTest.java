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

    @Test
    void mapMulti() {
        List<NewsStream.Triple> triples = new NewsStream().mapMulti(1, 2, 3, 4);
        Assertions.assertThat(triples)
                .containsExactly(new NewsStream.Triple(1, 2),
                        new NewsStream.Triple(1, 3),
                        new NewsStream.Triple(2, 3),
                        new NewsStream.Triple(1, 4),
                        new NewsStream.Triple(2, 4),
                        new NewsStream.Triple(3, 4));
    }

    @Test
    void flatMap() {
        List<NewsStream.Triple> triples = new NewsStream().flatmap(1, 2, 3, 4);
        Assertions.assertThat(triples)
                .containsExactly(new NewsStream.Triple(1, 2),
                        new NewsStream.Triple(1, 3),
                        new NewsStream.Triple(2, 3),
                        new NewsStream.Triple(1, 4),
                        new NewsStream.Triple(2, 4),
                        new NewsStream.Triple(3, 4));
    }
}