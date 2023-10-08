package com.bomfim.strings;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

class StringPoemTest {

    StringPoem stringPoem;

    @BeforeEach
    void setUp() {
        stringPoem = new StringPoem();
    }

    @org.junit.jupiter.api.Test
    void writePoem() {
        Assertions.assertThat(stringPoem.writePoem("Shakespeare"))
                .contains("Shakespeare");
    }

    @org.junit.jupiter.api.Test
    void writePoemBuilder() {
        Assertions.assertThat(stringPoem.writePoemBuilder("Shakespeare"))
                .contains("Shakespeare");
    }

    @org.junit.jupiter.api.Test
    void writePoemTextBlock() {
        Assertions.assertThat(stringPoem.writePoemTextBlock("Shakespeare"))
                .contains("Shakespeare");
    }

    @org.junit.jupiter.api.Test
    void writePoemStringTemplate() {
        Assertions.assertThat(stringPoem.writePoemStringTemplate("Shakespeare"))
                .contains("Shakespeare");
    }
}