package com.bomfim.java16;

import java.util.List;
import java.util.stream.Stream;

public class NewsStream {

    public List<Integer> toListStream(Integer ... values){
        return Stream.of(values)
                .toList(); //Since Java 16
    }


}
