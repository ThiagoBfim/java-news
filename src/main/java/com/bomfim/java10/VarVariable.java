package com.bomfim.java10;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * <a href="https://openjdk.org/jeps/286">Local-Variable Type Inference</a>
 */
public class VarVariable {

    //var x = 1; instance variable are not allowed

    public List<Integer> getPairsNumbersBetweenOneAndFive(/*var bigNumber could not infer the value from the arguments*/) {
        // var g = null; cannot infer type for local
        var list = new ArrayList<Integer>(); // infers ArrayList<Integer>
        for (var i = 0; i < 5; i++) {
            list.add(i);
        }
//        var var = x -> x % 2 == 0; could not infer lambda expression needs an explicit target-type
        Predicate<Integer> var = x -> x % 2 == 0;
        return list.stream().filter(var).collect(Collectors.toList());
    }


}
