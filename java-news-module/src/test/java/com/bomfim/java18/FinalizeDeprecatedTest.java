package com.bomfim.java18;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class FinalizeDeprecatedTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    void shouldExecuteMethodWithFinalize() {
        new FinalizeDeprecated().finalizeInternalCall();

        assertThat(outContent.toString()).contains("Finally",
                "error",
                "Thread:Thread[#1,main,5,main]")
                .doesNotContain("The end");

        //Executed by another thread.
        //The use of finalization can lead to problems with security, performance, and reliability. See JEP 421  for discussion and alternatives.
        assertThat(outContent.toString()).contains("Finalize Deprecated",
                "Thread:Thread[#5,Finalizer,8,system]");

    }
}