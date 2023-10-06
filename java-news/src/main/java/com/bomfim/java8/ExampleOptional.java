package com.bomfim.java8;

import java.util.Optional;
import java.util.function.Supplier;

public class ExampleOptional {

    public String toStringOrDefaultValue(Object object, MyString defaultValue) {
        return Optional.ofNullable(object)
                .map(Object::toString)
                .orElse(defaultValue.getDefaultValue());
    }

    public String toStringOrDefaultValueLazy(Object object, Supplier<MyString> defaultValue) {
        return Optional.ofNullable(object)
                .map(Object::toString)
                .orElseGet(() -> defaultValue.get().getDefaultValue());
    }

    static class MyString {

        private final String defaultValue;

        public MyString(String defaultValue) {
            this.defaultValue = defaultValue;
            System.out.println(defaultValue);
        }

        public String getDefaultValue() {
            return defaultValue;
        }
    }


}
