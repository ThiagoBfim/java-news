package com.bomfim.java14;

/**
 * <a href="https://openjdk.org/jeps/359">JEP 359: Records (Preview)</a>
 */
public class Records {

    public record Square(int x, int y) {

        public int calculateArea() {
            return x * y;
        }

    }
    public record Address(String street, String city, String country, String zipCode) {

    }


}
