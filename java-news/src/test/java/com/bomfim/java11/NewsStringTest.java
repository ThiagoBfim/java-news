package com.bomfim.java11;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NewsStringTest {

    @Test
    void getAllItemsSeparateByComma() {
        String allItemsSeparateByComma = new NewsString().getAllItemsSeparateByComma("\tbanana \n bread\npotato \n meat \nbeans\n rice\t");
        assertThat(allItemsSeparateByComma).isEqualTo("banana,bread,potato,meat,beans,rice");
    }

    @Test
    void stripLeading() {
        String nameWithoutSpace = new NewsString().stripLeading("\t James Gosling \u2005");
        assertThat(nameWithoutSpace).isEqualTo("James Gosling \u2005");
    }

    @Test
    void stripTrailing() {
        String nameWithoutSpace = new NewsString().stripTrailing("\t James Gosling \u2005");
        assertThat(nameWithoutSpace).isEqualTo("\t James Gosling");
    }

    @Test
    void stripIndent() {
        String nameWithoutSpace = new NewsString().stripIndent("\t James Gosling \u2005");
        assertThat(nameWithoutSpace).isEqualTo("James Gosling");
    }
}