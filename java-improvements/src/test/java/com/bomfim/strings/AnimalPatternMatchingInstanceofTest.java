package com.bomfim.strings;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static com.bomfim.strings.AnimalPatternMatchingInstanceof.Lion;
import static com.bomfim.strings.AnimalPatternMatchingInstanceof.Toucan;
import static org.assertj.core.api.Assertions.assertThat;

class AnimalPatternMatchingInstanceofTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;
    private AnimalPatternMatchingInstanceof animalPatternMatching;

    @BeforeEach
    void setUp() {
        animalPatternMatching = new AnimalPatternMatchingInstanceof();

        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }


    @Test
    void testEatWrong() {
        String food = animalPatternMatching.eatWrong(new Lion());
        Assertions.assertThat(food)
                .contains("Meat")
                .doesNotContain("Fruit");
    }

    @Test
    void testEat() {
        String food = animalPatternMatching.eat(new Lion());
        Assertions.assertThat(food)
                .contains("Meat")
                .doesNotContain("Fruit");
    }

    @Test
    void testDoActionOld() {
        animalPatternMatching.doAction(new Lion());
        assertThat(outContent.toString()).contains("Hunting")
                .contains("Climbing Tree")
                .doesNotContain("Flying");
    }

    @Test
    void testDoAction() {
        animalPatternMatching.doAction(new Toucan());
        assertThat(outContent.toString()).contains("Flying")
                .doesNotContain("Climbing Tree")
                .doesNotContain("Hunting");
    }
}