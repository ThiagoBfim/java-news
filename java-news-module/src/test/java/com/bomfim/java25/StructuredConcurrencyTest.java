package com.bomfim.java25;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class StructuredConcurrencyTest {

    @Test
    void testHandleAllSuccessOrException() {
        Assertions.assertThatThrownBy(() ->
                new StructuredConcurrency().handleAwaitAllSuccessfulOrThrow())
                .isInstanceOf(RuntimeException.class)
                .hasMessage("java.lang.RuntimeException: Internal Error from outside call");
    }

    @Test
    void testHandleAnySuccess() {
        Assertions.assertThatCode(() -> new StructuredConcurrency().handleAwaitAnySuccessfulOrThrow())
                .doesNotThrowAnyException();
    }


    @Test
    void testWithoutStructuredTaskScope() {
        Assertions.assertThatCode(() -> new StructuredConcurrency().withoutStructuredTaskScope())
                .doesNotThrowAnyException();
    }
}