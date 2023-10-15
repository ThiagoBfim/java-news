package com.bomfim.java21;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.entry;

class SequencedCollectionsTest {

    @Test
    void testGetFirstList() {
        var sequenced = new SequencedCollections();
        List<String> elements = List.of("A", "B", "C", "D");
        assertThat(sequenced.getFirst(elements)).isEqualTo("A");
    }

    @Test
    void testGetLastList() {
        var sequenced = new SequencedCollections();
        List<String> elements = List.of("A", "B", "C", "D");
        assertThat(sequenced.getLast(elements)).isEqualTo("D");
    }

    @Test
    void testGetLastSet() {
        var sequenced = new SequencedCollections();
        LinkedHashSet<String> elements = new LinkedHashSet<>(); //THERE IS NO SequencedCollection FOR HashSet
        elements.add("A");
        elements.add("B");
        elements.add("C");
        elements.add("D");
        assertThat(sequenced.getLast(elements)).isEqualTo("D");
    }

    @Test
    void testReverseList() {
        var sequenced = new SequencedCollections();
        List<String> elements = List.of("A", "B", "C", "D");
        assertThat(sequenced.reverse(elements)).containsExactly("D", "C", "B", "A");
    }

    @Test
    void testGetFirstMap() {
        var sequenced = new SequencedCollections();
        LinkedHashMap<String, String> elements = new LinkedHashMap<>(); //THERE IS NO SequencedMap FOR HASHMAP
        elements.put("1", "A");
        elements.put("2", "B");
        elements.put("3", "C");
        assertThat(sequenced.getFirst(elements)).isEqualTo(entry("1", "A"));
    }

    @Test
    void testGetLastMap() {
        var sequenced = new SequencedCollections();
        LinkedHashMap<String, String> elements = new LinkedHashMap<>(); //THERE IS NO SequencedMap FOR HASHMAP
        elements.put("1", "A");
        elements.put("2", "B");
        elements.put("3", "C");
        assertThat(sequenced.getLast(elements)).isEqualTo(entry("3", "C"));
    }

    @Test
    void testReverseMap() {
        var sequenced = new SequencedCollections();
        LinkedHashMap<String, String> elements = new LinkedHashMap<>(); //THERE IS NO SequencedMap FOR HASHMAP
        elements.put("1", "A");
        elements.put("2", "B");
        elements.put("3", "C");
        assertThat(sequenced.reverse(elements)).containsExactly(entry("3", "C"), entry("2", "B"), entry("1", "A"));
    }
}