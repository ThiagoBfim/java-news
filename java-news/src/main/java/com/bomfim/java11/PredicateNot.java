package com.bomfim.java11;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <a href="https://www.baeldung.com/java-11-new-features#4-the-not-predicate-method">The Not Predicate Method</a>
 */
public class PredicateNot {

    public boolean negateTheOperation(Predicate<String> operation, String text) {
        return Predicate.not(operation).test(text);
    }

    public List<String> filterValuesWithContent(String ... values) {
        return Stream.of(values)
                .filter(Predicate.not(String::isBlank))
                .collect(Collectors.toList());
    }


}
