package com.bomfim.java25;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.StructuredTaskScope;

class StructuredConcurrencyTest {

    @Test
    void testHandleAwaitAllSuccessOrException() {
        Assertions.assertThatThrownBy(() ->
                new StructuredConcurrency().handleAwaitAllSuccessfulOrThrow())
                .isInstanceOf(StructuredConcurrency.CustomException.class)
                .hasMessage("Internal Error from outside call");
    }

    @Test
    void testHandleAllSuccessOrException() {
        Assertions.assertThatThrownBy(() ->
                new StructuredConcurrency().handleAllSuccessfulOrThrow())
                .hasCauseExactlyInstanceOf(StructuredConcurrency.CustomException.class)
                .isInstanceOf(StructuredTaskScope.FailedException.class)
                .hasMessage("com.bomfim.java25.StructuredConcurrency$CustomException: Internal Error from outside call");
    }

    @Test
    void testHandleAwaitAll() {
        Assertions.assertThatCode(() ->
                new StructuredConcurrency().handleAwaitAll())
                .doesNotThrowAnyException();
    }

    @Test
    void testHandleCustomJoiner() {
        Assertions.assertThatCode(() ->
                new StructuredConcurrency().handleCustomJoiner())
                .doesNotThrowAnyException();
    }

    @Test
    void testHandleSuccessWithTimeoutConfiguration() {
        Assertions.assertThatCode(() ->
                new StructuredConcurrency().handleWithConfigurationTimeout())
                .doesNotThrowAnyException();
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