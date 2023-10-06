package com.bomfim.java9;

import java.util.stream.Stream;

/**
 * <a href="https://www.baeldung.com/java-9-stream-api">Java 9 Stream API Improvements</a>
 */
public class StreamNewMethods {

    public long getNumbersBiggerThanFour(int end) {
        Stream<Integer> stream = Stream.iterate(1, i -> i <= end, i -> i + 1);
        stream = stream
                .dropWhile(f -> f <= 4)//The dropWhile operation will remove elements while the given predicate for an element returns true and stops removing on the first predicate's false.
                .dropWhile(f -> f % 2 == 0); //Next iteration will be 5, will return false and will end this execution

        return stream
                .count();
    }

    public long getNumbersSmallerThanFour(int end) {
        Stream<Integer> stream = Stream
                .iterate(1, i -> i <= end, i -> i + 1) //This is a lazy operation too.
                .peek(System.out::println);

        stream = stream
                .takeWhile(f -> f <= 4); //The takeWhile operation will keep elements while the given predicate for an element returns true;

        return stream
                .count();
    }

    public long countThePairsNumbersInTheBeginningOfTheStream(int end) {
        Stream<Integer> stream = Stream.iterate(1, i -> i <= end, i -> i + 1);
        stream = stream
                .takeWhile(f -> f % 2 == 0); //Next iteration will be 1, will return false and will end this execution with zero elements in the Stream.

        return stream
                .count();
    }

}
