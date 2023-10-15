package com.bomfim.java19;

import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * <a href="https://openjdk.org/jeps/425">JEP 425: Virtual Threads (Preview)</a>
 */
public class VirtualThread {
    public void executeWithThreadPool() {
        try (var executor = Executors.newCachedThreadPool()) {
            IntStream.range(0, 8_000).forEach(i -> executor.submit(() -> {  // (1)
                Thread.sleep(Duration.ofSeconds(2).toMillis());
                return i;
            }));
            System.out.println("End Thread Pool");
        }
    }

    public void executeWithVirtualThread() {
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            IntStream.range(0, 8_000).forEach(i -> executor.submit(() -> {  // (1)
                Thread.sleep(Duration.ofSeconds(2));
                return i;
            }));
            System.out.println("End Virtual Thread");

        }

    }

}
