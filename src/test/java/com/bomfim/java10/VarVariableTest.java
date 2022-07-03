package com.bomfim.java10;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class VarVariableTest {

    @Test
    void getPairsNumbersBetweenOneAndFive() {
        var varVariable = new VarVariable();
        var pairs = varVariable.getPairsNumbersBetweenOneAndFive();
        assertThat(pairs).hasSize(3);
    }
}