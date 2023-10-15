package com.bomfim.java10;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OptionalOrElseThrowTest {

    @Test
    void shouldRetrieveLastName() {
        String lastName = new OptionalOrElseThrow().getLastNameOrElseThrow("Thiago Bomfim");
        assertThat(lastName).isEqualTo("Bomfim");
    }

    @Test
    void shouldRetrieveLastNameWithBigNames() {
        String lastName = new OptionalOrElseThrow().getLastNameOrElseThrow("Pablo Diego José Francisco de Paula Juan Nepomuceno María de los Remedios Cipriano de la Santísima Trinidad Ruiz y Picasso");
        assertThat(lastName).isEqualTo("Picasso");
    }
}