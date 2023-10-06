package com.bomfim.java11;

import java.util.stream.Collectors;

/**
 * <a href="https://www.baeldung.com/java-11-string-api">Java 11 String API Additions</a>
 */
public class NewsString {

    public String getAllItemsSeparateByComma(String shoppingCart) {
        if (!shoppingCart.isBlank()) {
            return shoppingCart.lines() //Lines with Stream
                    .map(String::strip) //Returns a string whose value is this string, with all leading and trailing white space removed.
                    .collect(Collectors.joining(","));
        }
        return "";
    }

    public String stripLeading(String name) {
       return name.stripLeading();
    }

    public String stripTrailing(String name) {
       return name.stripTrailing();
    }

    public String stripIndent(String name) {
       return name.stripIndent();
    }


}
