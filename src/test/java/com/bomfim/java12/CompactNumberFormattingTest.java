package com.bomfim.java12;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CompactNumberFormattingTest {

    @Test
    void compactNumberLong() {
        CompactNumberFormatting compactNumberFormatting = new CompactNumberFormatting();
        assertThat(compactNumberFormatting.compactNumberLong(10L)).isEqualTo("10");
        assertThat(compactNumberFormatting.compactNumberLong(100L)).isEqualTo("100");
        assertThat(compactNumberFormatting.compactNumberLong(1_500L)).isEqualTo("1.5 thousand");
        assertThat(compactNumberFormatting.compactNumberLong(10_501L)).isEqualTo("10.5 thousand");
        assertThat(compactNumberFormatting.compactNumberLong(1_000_000L)).isEqualTo("1 million");
        assertThat(compactNumberFormatting.compactNumberLong(1_000_000_000L)).isEqualTo("1 billion");
    }

    @Test
    void compactNumberShort() {
        CompactNumberFormatting compactNumberFormatting = new CompactNumberFormatting();
        assertThat(compactNumberFormatting.compactNumberShort(10L)).isEqualTo("10");
        assertThat(compactNumberFormatting.compactNumberShort(100L)).isEqualTo("100");
        assertThat(compactNumberFormatting.compactNumberShort(1_000L)).isEqualTo("1K");
        assertThat(compactNumberFormatting.compactNumberShort(10_000L)).isEqualTo("10K");
        assertThat(compactNumberFormatting.compactNumberShort(1_500_000L)).isEqualTo("1.5M");
        assertThat(compactNumberFormatting.compactNumberShort(1_000_500_000L)).isEqualTo("1B");

    }

}