package com.bomfim.java20;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PatternMatchingSwitch4PreviewTest {

    @Test
    void calculateArea() {

        var patternMatchingSwitch = new PatternMatchingSwitch4Preview();
        assertThat(patternMatchingSwitch.printToString(null)).isEmpty();
        assertThat(patternMatchingSwitch.printToString("square")).isEqualTo("square");
        assertThat(patternMatchingSwitch.printToString(0.05)).isEqualTo("0.05");
        assertThat(patternMatchingSwitch.printToString(1)).isEqualTo("not defined");
    }
}