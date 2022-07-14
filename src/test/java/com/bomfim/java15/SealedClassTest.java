package com.bomfim.java15;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SealedClassTest {

    @Test
    void shouldCalculateAreaFromDifferentShape() {
        var rectangle = new SealedClass.Rectangle(10, 2);
        var square = new SealedClass.Square(10);
        var circle = new SealedClass.Circle(10);

        var sealedClass = new SealedClass();
        assertThat(sealedClass.calculateArea(rectangle)).isEqualTo(20);
        assertThat(sealedClass.calculateArea(square)).isEqualTo(100);
        assertThat(sealedClass.calculateArea(circle)).isEqualTo(314.1592653589793);

    }
}