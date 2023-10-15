package com.bomfim.java8;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * <a href="https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html">Stream documentation</a>
 * <a href="https://www.oracle.com/br/technical-resources/articles/java-stream-api.html">Java 8: Iniciando o desenvolvimento com a Streams API</a>
 */
public class ExampleStream {

    public long countPairsNumbers(int end) {
        List<Integer> generated = IntStream.rangeClosed(1, end).boxed().toList(); //Java 8 .collect(Collectors.toList());

        Stream<Integer> stream = generated.stream() //This Stream is not executed now, Streams are Lazy
                .peek(System.out::println);  //Intermediate operator

        return stream
                .filter(f -> f % 2 == 0) //Intermediate operator
                .count(); //final operator
    }

    public long countPairsNumbersParallel(int end) {
        List<Integer> generated = IntStream.rangeClosed(1, end).boxed().toList();

        Stream<Integer> streamParallel = generated.stream()
                .parallel() //Intermediate operator
                .peek(System.out::println);

        return streamParallel
                .filter(f -> f % 2 == 0)
                .count();
    }

    public List<Integer> errorStream(int end) {
        List<Integer> generated = IntStream.rangeClosed(1, end).boxed().toList();
        Stream<Integer> stream = generated.stream();
        long count = stream
                .count();  //final operator
        if (count > 0) {
            return stream
                    .collect(Collectors.toList());  //final operator
        }
        return Collections.emptyList();
    }


}
