package com.bomfim.java10;

import java.util.Optional;

/**
 * <a href="https://www.baeldung.com/java-10-overview#optionalorelsethrow">Java 10 Overview</a>
 */
public class OptionalOrElseThrow {

    public String getLastNameOrElseThrow(String fullName) {
        return Optional.ofNullable(fullName)
                .map(n -> {
                    String[] names = n.split(" ");
                    return names[names.length-1];
                })
                .orElseThrow();
    }


}
