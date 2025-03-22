package com.bomfim.java24;

import java.util.List;
import java.util.stream.Gatherer;

/**
 * JEP 485: Stream Gatherers
 */
public class StreamGatherFinal {

    public List<Integer> getValuesUntilOddNumber(List<Integer> values) {
        return values
                .stream()
                .gather(Gatherer.of((Gatherer.Integrator<Void, Integer, Integer>) (_, value, downstream) -> {
                    if (value % 2 == 0) {
                        downstream.push(value);
                        return true;
                    }
                    return false;
                }))
                .toList();
    }

}
