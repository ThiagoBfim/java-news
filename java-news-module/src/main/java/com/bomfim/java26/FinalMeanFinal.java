package com.bomfim.java26;

public class FinalMeanFinal {

    static class C {
        final int x;
        C() { x = 100; }
    }

    static void main() throws NoSuchFieldException, IllegalAccessException {
        C c = new C();
        java.lang.reflect.Field f = C.class.getDeclaredField("x");
        f.setAccessible(true);
        f.set(c, 200);
        System.out.println(c.x);
    }
}
