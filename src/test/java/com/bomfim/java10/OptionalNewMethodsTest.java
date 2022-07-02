package com.bomfim.java10;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OptionalNewMethodsTest {

    @Test
    void shouldRetrieveLastName() {
        String lastName = new OptionalNewMethods().getLastNameOrElseThrow("Thiago Bomfim");
        assertThat(lastName).isEqualTo("Bomfim");
    }

    @Test
    void shouldRetrieveLastNameWithBigNames() {
        String lastName = new OptionalNewMethods().getLastNameOrElseThrow("Pablo Diego José Francisco de Paula Juan Nepomuceno María de los Remedios Cipriano de la Santísima Trinidad Ruiz y Picasso");
        assertThat(lastName).isEqualTo("Picasso");
    }
}