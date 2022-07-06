package com.bomfim.java11;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class NewsFileTest {

    @Test
    void shouldWriteAndReadFromFile() throws IOException {
        String text = new NewsFile().writeAndReadFromFile(" My Text\n news");
        assertThat(text).isEqualTo(" My Text\n news");
    }
}