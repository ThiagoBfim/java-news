package com.bomfim.java10;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <a href="https://www.baeldung.com/java-10-overview#unmodifiable-collections">Java 10 Overview</a>
 */
public class CopyUnmodifiable {

    public List<Integer> createUnmodifiableCopy(List<Integer> numbers) {
        return List.copyOf(numbers);
    }

    public Set<Integer> createUnmodifiableCopy(Set<Integer> numbers) {
        return Set.copyOf(numbers);
    }

    public Map<Integer, Integer> createUnmodifiableCopy(Map<Integer, Integer> numbers) {
        return Map.copyOf(numbers);
    }


}
