package com.bomfim.java11;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class PredicateNotTest {

    @Test
    void negateTheOperation() {
        boolean isNotBlank = new PredicateNot().negateTheOperation(String::isBlank, "  ");
        assertThat(isNotBlank).isFalse();
    }

    @Test
    void getListElementsWithValue() {
        List<String> valuesWithContent = new PredicateNot().filterValuesWithContent("  ", "Java", "JS", "", "\t", "\u2005");
        assertThat(valuesWithContent).containsExactly("Java", "JS");
    }
}