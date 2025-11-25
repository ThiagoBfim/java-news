package com.bomfim.java25;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * JEP 506: Scoped Values: https://openjdk.org/jeps/506
 */
public class ScopedValueAndThreadLocalExample {

    private static final ScopedValue<String> NAME = ScopedValue.newInstance();
    static char[] s = new char[1024 * 1000];
    static String str = String.copyValueOf(s);
    public static void main(String[] args) {
        scopedValue();
        threadLocal();
    }

    private static void threadLocal() {

        ThreadLocal<String> threadLocal = ThreadLocal.withInitial(() -> str);
        try(ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {

            for (int i = 0; i < 100_000; i++) {
                int finalI = i;
                executor.execute(() -> {
                    System.out.println("count " + finalI + " - " + threadLocal);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
            }

        }
    }

    private static void scopedValue() {
        try(ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {

            for (int i = 0; i < 100_000; i++) {
                int finalI = i;
                ScopedValue.where(NAME, str)
                        .run(() -> {
                            String name = NAME.get();
                            executor.execute(() -> {
                                System.out.println("count " + finalI + " - " + name.hashCode());
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                            });
                        });
            }

        }
    }
}
