package com.bomfim.java25;

import java.util.concurrent.StructuredTaskScope;

/**
 * JEP 506: Scoped Values: https://openjdk.org/jeps/506
 */
public class ScopedValueExample {
    private static final ScopedValue<String> NAME = ScopedValue.newInstance();

    public static void main(String[] args) {
        ScopedValue.where(NAME, "Value")
                .run(() -> {
                    String name = NAME.get();

                    Thread.ofVirtual().start(() -> {
                        System.out.println(NAME.orElse("Not bound"));
                        System.out.println(name);
                    });

                    System.out.println(Thread.currentThread().getName());
                    System.out.println(name);

                    // Works seamlessly with Structured Concurrency
                    // When used within a StructuredTaskScope, ScopedValue bindings are automatically inherited by all child threads created within that scope
                    try (var scope = StructuredTaskScope.open(
                            StructuredTaskScope.Joiner.<String>allSuccessfulOrThrow()
                    )) {
                        scope.fork(() -> NAME.get() + " from task 1");
                        scope.fork(() -> NAME.get() + " from task 2");

                        var values = scope.join();
                        values.forEach(v -> System.out.println(v.get()));
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
    }
}
