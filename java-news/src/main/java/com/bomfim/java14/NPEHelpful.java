package com.bomfim.java14;

/**
 * <a href="https://openjdk.org/jeps/358">JEP 358: Helpful NullPointerExceptions</a>
 */
public class NPEHelpful {

    int getRoomQtdDoor(House house) {
        return house.room.qtdDoor;
    }

    record House(Room room){};
    record Room(Integer qtdDoor, Integer qtdWindows){};



}
