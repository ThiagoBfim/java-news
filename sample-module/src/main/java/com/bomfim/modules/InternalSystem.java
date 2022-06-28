package com.bomfim.modules;

public class InternalSystem {

    public void sysOut(String text) {
        System.out.println("Internal method");
        System.err.println(text);
    }
}
