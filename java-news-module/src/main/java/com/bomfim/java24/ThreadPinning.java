package com.bomfim.java24;

import java.util.List;
import java.util.stream.IntStream;

/**
 * JEP 491: Synchronize Virtual Threads without Pinning
 */
public class ThreadPinning {

    private static final Object lock = new Object();

    public static void main(String[] args) {
        List<Thread> threadList = IntStream.range(0, 10)
                .mapToObj(i -> Thread.ofVirtual().unstarted(() -> {
                    if (i == 0) {
                        System.out.println(Thread.currentThread());
                    }
                    synchronized (lock) {
                        try {
                            Thread.sleep(25);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    if (i == 0) {
                        System.out.println(Thread.currentThread());
                    }
                })).toList();

        threadList.forEach(Thread::start);
        threadList.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
    }
}
