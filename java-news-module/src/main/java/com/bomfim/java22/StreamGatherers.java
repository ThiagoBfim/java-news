package com.bomfim.java22;


import java.util.Comparator;
import java.util.List;
import java.util.stream.Gatherers;

/**
 * <a href="https://openjdk.org/jeps/461">https://openjdk.org/jeps/461</a>
 */
public class StreamGatherers {

    /**
     * Input  : arr[] = {1, 4, 2, 10, 23, 3, 1, 0, 20}, k = 4
     * Output : 39
     * We get maximum sum by adding subarray {4, 2, 10, 23} of size 4.
     */

    public List<Integer> getMaxSumOfConsecutiveElements(List<Integer> values, Integer windowSize) {
        return values
                .stream()
                .gather(Gatherers.windowSliding(windowSize))
                .max(getMax())
                .orElse(null);
    }

    private static Comparator<List<Integer>> getMax() {
        return (o1, o2) -> Integer.compare(o1.stream().mapToInt(i -> i).sum(), o2.stream().mapToInt(i -> i).sum());
    }

}
