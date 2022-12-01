package com.bomfim.java19;

import java.text.NumberFormat;
import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

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
