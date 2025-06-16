package com.bomfim.java25;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

class ModuleImportDeclarationsTest {

    @Test
    void addElements() {
        Map<Integer, List<String>> result = new ModuleImportDeclarations().addElements("v1", "v2");
        Assertions.assertThat(result).containsEntry(2, List.of("v1", "v2"));
    }
}