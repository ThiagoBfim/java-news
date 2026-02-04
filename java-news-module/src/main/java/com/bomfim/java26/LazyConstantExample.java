package com.bomfim.java26;

/**
 * JEP 526: Lazy Constants (Second Preview)
 */
public class LazyConstantExample {

    private static final LazyConstant<LazyClass> lazyClass = LazyConstant.of(() -> new LazyClass());

    public static void main(String[] args) {
        System.out.println("Initialize");
        lazyClass.get().printClassName();
        System.out.println("End");
    }

    private static class LazyClass {

        LazyClass() {
            System.out.println("LazyClass created");
        }

        public void printClassName() {
            System.out.println(this.getClass().getName());
        }
    }
}
