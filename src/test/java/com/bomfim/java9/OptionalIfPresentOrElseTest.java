package com.bomfim.java9;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class OptionalIfPresentOrElseTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }
    
    @Test
    void shouldPrintLastName() {
        new OptionalIfPresentOrElse().printLastNameOrElseEmpty("Joseph Silva");
        assertThat(outContent.toString()).contains("Silva");
    }

    @Test
    void shouldPrintEmpty() {
        new OptionalIfPresentOrElse().printLastNameOrElseEmpty(null);
        assertThat(outContent.toString()).contains("Empty");
    }

    @Test
    void shouldPrintFullName() {
        new OptionalIfPresentOrElse().printFullNameOrEmpty("Joseph Silva");
        assertThat(outContent.toString()).contains("Joseph Silva");
    }

    @Test
    void shouldPrintEmptyWhenFullNameIsNull() {
        new OptionalIfPresentOrElse().printFullNameOrEmpty(null);
        assertThat(outContent.toString()).contains("Empty");
    }
}