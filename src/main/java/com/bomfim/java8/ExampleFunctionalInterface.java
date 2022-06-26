package com.bomfim.java8;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html">Package java.util.function</a>
 */
public class ExampleFunctionalInterface {

    final List<String> names;

    public ExampleFunctionalInterface(List<String> names) {
        this.names = names;
    }

    public long consumeNames(Consumer<String> consume) {
        AtomicLong value = new AtomicLong(0);
        long count = names.stream()
                .peek(n -> {
                    consume.accept(n);
                    value.incrementAndGet();
                })
                .filter(String::isEmpty)
                .count(); //Should return 0
        return value.get() + count;
    }

    public long predicateNames(Predicate<String> predicate) {
        return names
                .stream()
                .filter(n -> predicate.test(n))
                .count();
    }

    public long functionNames(Function<String, Integer> function) {
        return names
                .stream()
                .mapToInt(n -> function.apply(n))
                .sum();
    }

}
