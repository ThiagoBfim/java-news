package com.bomfim.improvements;

import com.bomfim.improvements.AnimalSwitchPattern.Lion;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static com.bomfim.improvements.AnimalSwitchPattern.Toucan;
import static org.assertj.core.api.Assertions.assertThat;

class AnimalSwitchPatternTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;
    private AnimalSwitchPattern animalSwitchPattern;

    @BeforeEach
    void setUp() {
        animalSwitchPattern = new AnimalSwitchPattern();
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
        String food = animalSwitchPattern.eatWrong(new Lion());
        Assertions.assertThat(food)
                .contains("Meat")
                .doesNotContain("Fruit");
    }

    @Test
    void testDoActionOld() {
        animalSwitchPattern.doAction(new Lion());
        assertThat(outContent.toString()).contains("Hunting")
                .contains("Climbing Tree")
                .doesNotContain("Flying");
    }

    @Test
    void testDoAction() {
        animalSwitchPattern.doAction(new Toucan());
        assertThat(outContent.toString()).contains("Flying")
                .doesNotContain("Climbing Tree")
                .doesNotContain("Hunting");
    }
}