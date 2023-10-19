package com.bomfim.java16;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NewsStream {

    public List<Integer> toListStream(Integer... values) {
        return Stream.of(values)
                .toList(); //Since Java 16
    }

    /**
     * Done by JDK-8238286
     * <p>
     * mapMulti has a better performance than flatmap
     * <a href="https://github.com/Nikolas-Charalambidis/java-16-mapmulti-benchmark/tree/master">Java 16 MapMulti Benchmark</a>
     * @param values
     * @return
     */
    public List<Triple> mapMulti(Integer... values) {
        return Stream.of(values)
                .<Triple>mapMulti((a, b) -> IntStream.range(1, a)
                        .mapToObj(n -> new Triple(n, a))
                        .forEach(b))
                .collect(Collectors.toList());
    }

    public List<Triple> flatmap(Integer... values) {
        return Stream.of(values)
                .flatMap((a) -> IntStream.range(1, a)
                        .mapToObj(n -> new Triple(n, a)))
                .collect(Collectors.toList());
    }

    private Triple getTriple(Integer a, int n) {
        return new Triple(a, n);
    }

    record Triple(int a, int b) {
    }

}
