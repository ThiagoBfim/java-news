package com.bomfim.java9;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class OfUnmodifiable {


    public List<Integer> createUnmodifiableList(Integer... numbers) {
        return List.of(numbers);
    }

    public Set<Integer> createUnmodifiableSet(Integer... numbers) {
        return Set.of(numbers);
    }

    public Map<Integer, Integer> createUnmodifiableMap(Integer key, Integer value, Integer key2, Integer value2) {
        return Map.of(key, value, key2, value2);
    }

}
