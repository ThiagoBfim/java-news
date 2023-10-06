package com.bomfim.java19;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class VirtualThreadTest {


    @Test
    void compareThreads() {
        var virtualThread = new VirtualThread();
        long startTime = System.currentTimeMillis();
        virtualThread.executeWithThreadPool();
        long endTime = System.currentTimeMillis();
        long threadTime = endTime - startTime;

        startTime = System.currentTimeMillis();
        virtualThread.executeWithVirtualThread();
        endTime = System.currentTimeMillis();
        long virtualThreadTime = endTime - startTime;

        System.out.println("Virtual Thread took " + virtualThreadTime + " milliseconds");
        System.out.println("Thread took " + threadTime + " milliseconds");
        assertThat(virtualThreadTime).isLessThan(threadTime);

    }
}