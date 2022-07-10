package com.bomfim.java14;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class NPEHelpfulTest {

    @Test
    void getRoomQtdDoor() {
        var house = new NPEHelpful.House(new NPEHelpful.Room(null, null));
        var npeHelpful = new NPEHelpful();

        Assertions.assertThatThrownBy(() -> npeHelpful.getRoomQtdDoor(house))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("Cannot invoke \"java.lang.Integer.intValue()\" because \"house.room.qtdDoor\" is null");
    }
}