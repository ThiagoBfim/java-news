package com.bomfim.java21;

import java.util.Map;
import java.util.SequencedCollection;
import java.util.SequencedMap;

/**
 * <a href="https://openjdk.org/jeps/431">JEP 431: Sequenced Collections</a>
 */
public class SequencedCollections {

    public String getFirst(SequencedCollection<String> collection){
        return collection.getFirst();
    }

    public String getLast(SequencedCollection<String> collection){
        return collection.getLast();
    }

    public SequencedCollection<String> reverse(SequencedCollection<String> collection){
        return collection.reversed();
    }

    public Map.Entry<String, String> getFirst(SequencedMap<String, String> collection){
        return collection.firstEntry();
    }

    public Map.Entry<String, String> getLast(SequencedMap<String, String> collection){
        return collection.lastEntry();
    }


    public SequencedMap<String, String> reverse(SequencedMap<String, String> collection){
        return collection.reversed();
    }
}
