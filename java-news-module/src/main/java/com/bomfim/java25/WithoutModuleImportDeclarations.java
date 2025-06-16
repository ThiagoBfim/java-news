package com.bomfim.java25;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WithoutModuleImportDeclarations {

    public Map<Integer, List<String>> addElements(String element, String element2) {
        List<String> list = new ArrayList<>();
        list.add(element);
        Set<String> set = new HashSet<>();
        set.add(element2);
        return Stream.concat(list.stream(), set.stream())
                .collect(Collectors.groupingBy(s -> s.length()));
    }
}
