package com.bomfim.java17;

import com.bomfim.java15.SealedClass;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PatternMatchingSwitchTest {

    @Test
    void calculateArea() {
        var rectangle = new SealedClass.Rectangle(10, 2);
        var square = new SealedClass.Square(10);
        var circle = new SealedClass.Circle(10);

        var patternMatchingSwitch = new PatternMatchingSwitch();
        assertThat(patternMatchingSwitch.calculateArea(rectangle)).isEqualTo(20);
        assertThat(patternMatchingSwitch.calculateArea(square)).isEqualTo(100);
        assertThat(patternMatchingSwitch.calculateArea(circle)).isEqualTo(314.1592653589793);
    }
}