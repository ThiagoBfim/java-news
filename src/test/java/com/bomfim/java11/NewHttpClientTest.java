package com.bomfim.java11;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class NewHttpClientTest {

    @Test
    void shouldGetContentFromMartinFowlerBlog() throws IOException, InterruptedException {
        Object contentFromUrl = new NewHttpClient().getContentFromUrl("https://martinfowler.com/");
        Assertions.assertThat(contentFromUrl.toString())
                .contains("A website on building software effectively")
                .contains("Refactoring", "Agile", "Delivery", "Microservices", "Data", "Testing", "DSL");
    }
}