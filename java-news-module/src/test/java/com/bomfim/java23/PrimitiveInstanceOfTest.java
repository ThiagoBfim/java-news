package com.bomfim.java23;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PrimitiveInstanceOfTest {

    @Test
    void testAgeRange() {
        var primitiveInstanceOf = new PrimitiveInstanceOf();
        Assertions.assertThat(primitiveInstanceOf.getAgeRange(13)).isEqualTo("KID");
        Assertions.assertThat(primitiveInstanceOf.getAgeRange(21)).isEqualTo("ADULT");
        Assertions.assertThat(primitiveInstanceOf.getAgeRange(51)).isEqualTo("OLDER");
    }
}