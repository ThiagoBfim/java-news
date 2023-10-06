package com.bomfim.java18;

/**
 * <a href="https://openjdk.org/jeps/421">JEP 421: Deprecate Finalization for Removal</a>
 */
public class FinalizeDeprecated {
    public void finalizeInternalCall() {
        MyClass myClass = new MyClass();
        try {
            myClass.throwException();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            myClass = null;
            System.gc();
            System.out.println("Finally");
            System.out.println("Thread:" + Thread.currentThread());
        }
    }


    public class MyClass {

        public void throwException() {
            throw new RuntimeException("error");
        }

        @Override
        protected void finalize() {
            System.out.println("Finalize Deprecated");
            System.out.println("Thread:" + Thread.currentThread());
            throw new RuntimeException("The end");
        }
    }



}
