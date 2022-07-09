package com.bomfim.java13;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class SwitchExpressionYieldTest {

    @Test
    void shouldCountLettersFromDayUsingOldSwitchExpression() {
        SwitchExpressionYield switchExpression = new SwitchExpressionYield();
        Assertions.assertThat(switchExpression.getNumbersLettersOldSwitch("FRIDAY")).isEqualTo(6);
        Assertions.assertThat(switchExpression.getNumbersLettersOldSwitch("TUESDAY")).isEqualTo(7);
        Assertions.assertThat(switchExpression.getNumbersLettersOldSwitch("THURSDAY")).isEqualTo(8);
        Assertions.assertThat(switchExpression.getNumbersLettersOldSwitch("WEDNESDAY")).isEqualTo(9);
        Assertions.assertThat(switchExpression.getNumbersLettersOldSwitch("FAKE")).isEqualTo(4);
    }

    @Test
    void shouldCountLettersFromDayUsingNewSwitchExpression() {
        SwitchExpressionYield switchExpression = new SwitchExpressionYield();
        Assertions.assertThat(switchExpression.getNumbersLettersNewSwitch("FRIDAY")).isEqualTo(6);
        Assertions.assertThat(switchExpression.getNumbersLettersNewSwitch("TUESDAY")).isEqualTo(7);
        Assertions.assertThat(switchExpression.getNumbersLettersNewSwitch("THURSDAY")).isEqualTo(8);
        Assertions.assertThat(switchExpression.getNumbersLettersNewSwitch("WEDNESDAY")).isEqualTo(9);
        Assertions.assertThat(switchExpression.getNumbersLettersNewSwitch("FAKE")).isEqualTo(4);
    }
}