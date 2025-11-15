package com.bomfim.java25;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.StructuredTaskScope;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

/**
 * JEP 505: Structured Concurrency (Fifth Preview)
 */
public class StructuredConcurrency {

    void withoutStructuredTaskScope() throws Exception {
        try (var executorService = Executors.newVirtualThreadPerTaskExecutor()) {
            Future<String> users = executorService.submit(() -> executeExternalCall(Behavior.run("fetch user", 500)));
            Future<String> account = executorService.submit(() -> executeExternalCall(Behavior.fail("fetch account", 500)));

            if(users.isDone() && account.isDone()) {
                System.out.println(users.get());
                System.out.println(account.get());
            }
        }
    }

    void handleAwaitAllSuccessfulOrThrow() throws Exception {
        try (var scope = StructuredTaskScope.open()) {
            StructuredTaskScope.Subtask<String> users = scope
                    .fork(() -> executeExternalCall(Behavior.run("fetch user", 500)));
            StructuredTaskScope.Subtask<String> account = scope
                    .fork(() -> executeExternalCall(Behavior.fail("fetch account", 500)));

            scope.join();

            System.out.println(formatResults(users, account));
        }
    }

    void handleAwaitAnySuccessfulOrThrow() throws Exception {
        try (var scope = StructuredTaskScope.open(StructuredTaskScope.Joiner.anySuccessfulResultOrThrow())) {
            StructuredTaskScope.Subtask<String> users = scope
                    .fork(() -> executeExternalCall(Behavior.run("fetch user", 500)));
            StructuredTaskScope.Subtask<String> account = scope
                    .fork(() -> executeExternalCall(Behavior.fail("fetch account", 500)));

            scope.join();

            System.out.println(formatResults(users, account));
        }
    }

    private String executeExternalCall(Behavior behavior) throws InterruptedException {
        String message = behavior.message;
        log("Initialize - " + message);
        if (behavior.failed) {
            log("Ending with Error - " + message);
            throw new RuntimeException("Internal Error from outside call");
        }
        Thread.sleep(behavior.millisecondsDealy);
        log("Ending - " + message);
        return message;
    }


    private record Behavior(String message, int millisecondsDealy, boolean failed) {
        public static Behavior run(String message, int millisecondsDealy) {
            return new Behavior(message, millisecondsDealy, false);
        }

        public static Behavior fail(String message, int millisecondsDealy) {
            return new Behavior(message, millisecondsDealy, true);
        }
    }

    /**
     * Reference: https://github.com/Modern-Concurrency-in-Java/modern-concurrency-java-book/blob/1d96178abc07075a45efd85c375fd324ef156533/src/ca/bazlur/modern/concurrency/c04/Utils.java
     */
    private static void log(String message) {
        Thread currentThread = Thread.currentThread();
        String threadName = currentThread.isVirtual()
                ? "VThread[#" + currentThread.threadId() + "]"
                : currentThread.getName();
        String currentTime = LocalTime.now()
                .format(DateTimeFormatter.ofPattern("HH:mm:ss.SSS"));
        System.out.printf("%s %-12s: %s%n", currentTime, threadName, message);
    }


    /**
     * Reference: https://github.com/nipafx/scia/blob/main/src/main/java/dev/nipafx/scia/task/Task.java
     */
    private static String formatResults(StructuredTaskScope.Subtask<?>... tasks) {
        return Stream
                .of(tasks)
                .map(subtask -> switch (subtask.state()) {
                    case UNAVAILABLE -> throw new IllegalStateException("Subtask result unavailable");
                    case SUCCESS -> "✅ " + subtask.get();
                    case FAILED -> "❌️ " + subtask.exception().getMessage();
                })
                .collect(joining("\n\t", "Result:\n\t", ""));
    }

}