package com.bomfim.java14;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RecordsTest {

    @Test
    void shouldCalculateAreaFormSquare() {
        var square = new Records.Square(1, 2);
        assertThat(square.calculateArea()).isEqualTo(2);
    }

    @Test
    void shouldCreateTwoAddress() {
        var address1 = new Records.Address("1", "NY", "EUA", "10001");
        var address2 = new Records.Address("2", "NY", "EUA", "10001");
        var address3 = new Records.Address("1", "NY", "EUA", "10001");
        assertThat(address1).isNotEqualTo(address2);
        assertThat(address1).isEqualTo(address3);
    }
}