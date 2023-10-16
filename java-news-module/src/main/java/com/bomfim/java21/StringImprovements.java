package com.bomfim.java21;

import java.util.regex.Pattern;

public class StringImprovements {

    /**
     * New String indexOf(int,int,int) and indexOf(String,int,int)
     * Methods to Support a Range of Indices (JDK-8302590)
     *
     * @param text
     * @return
     */
    public int indexOfRangeAfter5Character(String text) {
        return text.indexOf("a", 5, 10);
    }

    /**
     * New splitWithDelimiters() Methods Added to String and java.util.regex.Pattern (JDK-8305486)
     *
     * @param text
     * @return
     */
    public String[] splitWithDelimiters(String text, String pattern) {
        return text.splitWithDelimiters(pattern, 5);
    }

    /**
     * New splitWithDelimiters() Methods Added to String and java.util.regex.Pattern (JDK-8305486)
     *
     * @param text
     * @return
     */
    public City splitWithDelimitersPattern(String text) {

        var p = Pattern.compile("""
                        (?<index>\\d+);\
                        (?<city>[a-zA-Z]+);\
                        (?<population>[ \\d]+)$\
                        """)
                .matcher("1;Lisbon;504 718");
        while (p.matches()) {
            int index = Integer.parseInt(p.group("index"));
            var city = p.group("city");
            var population = p.group("population");
            return new City(index, city, population);
        }
        return null;
    }

    record City(int index, String city, String population) {
    }

}
