package com.bomfim.java12;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TeeingCollector {

    public String minAndMaxValue(Integer... values) {
        return Stream.of(values)
                .collect(Collectors.teeing(
                        Collectors.maxBy(Integer::compareTo),
                        Collectors.minBy(Integer::compareTo),
                        (a, b) -> "Max - " + a.get() + " Min - " + b.get()
                ));
    }


}
