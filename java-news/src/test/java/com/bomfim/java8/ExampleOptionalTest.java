package com.bomfim.java8;

import com.bomfim.java8.ExampleOptional.MyString;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.function.Supplier;

class ExampleOptionalTest {

    @Test
    @DisplayName("Should return to String from Object")
    void testToString() {
        String zero = new ExampleOptional().toStringOrDefaultValue(BigInteger.ZERO, new MyString("0"));
        Assertions.assertThat(zero).isEqualTo("0");
    }

    @Test
    @DisplayName("Should return default value when Object is Null")
    void testDefaultValue() {
        MyString defaultValue =  new MyString("0");
        String zero = new ExampleOptional().toStringOrDefaultValue(null, defaultValue);
        Assertions.assertThat(zero).isEqualTo("0");
    }

    @Test
    @DisplayName("Should return toString without creating MyString Object")
    void toStringLazy() {
        Supplier<MyString> defaultValue = () -> new MyString("1");
        String zero = new ExampleOptional().toStringOrDefaultValueLazy(BigInteger.ONE, defaultValue);
        Assertions.assertThat(zero).isEqualTo("1");
    }


    @Test
    @DisplayName("Should return default value Lazy when Object is Null")
    void testDefaultLazy() {
        Supplier<MyString> defaultValue = () -> new MyString("1");
        String zero = new ExampleOptional().toStringOrDefaultValueLazy(null, defaultValue);
        Assertions.assertThat(zero).isEqualTo("1");
    }


}