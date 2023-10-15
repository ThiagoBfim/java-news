package com.bomfim.java9;

import java.util.Optional;

/**
 * <a href="https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Optional.html">Optional</a>
 */
public class OptionalIfPresentOrElse {

    public void printLastNameOrElseEmpty(String fullName) {
        Optional.ofNullable(fullName)
                .ifPresentOrElse(n -> {
                    String[] names = n.split(" ");
                    System.out.println(names[names.length-1]);
                }, () -> System.out.println("Empty"));
    }

    public void printFullNameOrEmpty(String fullName) {
        String nameOrEmpty = Optional.ofNullable(fullName)
                .or(() -> Optional.of("Empty"))
                .get();
        System.out.println(nameOrEmpty);
    }


}
