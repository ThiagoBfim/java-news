package com.bomfim.java22;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StatementBeforeSuperTest {

    @Test
    void createDogAnimal() {
        StatementBeforeSuper.Animal ollie = new StatementBeforeSuper().createAnimal("Ollie");
        assertThat(ollie.getName()).isEqualTo("Dog");
    }

    @Test
    void createCatAnimal() {
        StatementBeforeSuper.Animal ollie = new StatementBeforeSuper().createAnimal("Nala");
        assertThat(ollie.getName()).isEqualTo("Cat");
    }
}