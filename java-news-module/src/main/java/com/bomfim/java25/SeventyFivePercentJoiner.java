package com.bomfim.java25;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.StructuredTaskScope;
import java.util.concurrent.StructuredTaskScope.Subtask.State;
import java.util.concurrent.atomic.AtomicInteger;

public final class SeventyFivePercentJoiner<T>
        implements StructuredTaskScope.Joiner<T, List<T>> {

    private final AtomicInteger totalForked = new AtomicInteger(0);
    private final AtomicInteger successCount = new AtomicInteger(0);
    private final Queue<T> successResults = new ConcurrentLinkedQueue<>();

    @Override
    public boolean onFork(StructuredTaskScope.Subtask<? extends T> subtask) {
        totalForked.incrementAndGet();
        return false;
    }

    @Override
    public boolean onComplete(StructuredTaskScope.Subtask<? extends T> subtask) {
        if (subtask.state() == State.SUCCESS) {
            successResults.add(subtask.get());
            successCount.incrementAndGet();
        }
        return false;
    }

    @Override
    public List<T> result() throws Throwable {
        int total = totalForked.get();
        if (total == 0) {
            throw new IllegalStateException("No subtasks were forked");
        }

        int succeeded = successCount.get();
        double successRate = (double) succeeded / total;

        if (successRate >= 0.75) {
            return new ArrayList<>(successResults);
        }


        throw new IllegalStateException(
                String.format("Joiner failed: success rate %.2f%% (%d/%d)",
                        successRate * 100, succeeded, total));
    }
}
