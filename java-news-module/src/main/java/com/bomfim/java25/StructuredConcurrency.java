package com.bomfim.java25;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
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

            Void join = scope.join();

            System.out.println(formatResults(users, account));
        } catch (StructuredTaskScope.FailedException e) {
            log("Task failed: " + e.getCause().getMessage());
            throw (Exception) e.getCause();
        }
    }

    void handleAwaitAnySuccessfulOrThrow() throws Exception {
        try (var scope = StructuredTaskScope.open(StructuredTaskScope.Joiner.anySuccessfulResultOrThrow())) {
            StructuredTaskScope.Subtask<String> users = scope
                    .fork(() -> executeExternalCall(Behavior.run("fetch user", 500)));
            StructuredTaskScope.Subtask<String> account = scope
                    .fork(() -> executeExternalCall(Behavior.fail("fetch account", 500)));

            Object join = scope.join();
            System.out.println("Successful Result: " + join);

            System.out.println(formatResults(users, account));
        }
    }

    void handleAllSuccessfulOrThrow() throws Exception {
        try (var scope = StructuredTaskScope.open(StructuredTaskScope.Joiner.allSuccessfulOrThrow())) {
            StructuredTaskScope.Subtask<String> users = scope
                    .fork(() -> executeExternalCall(Behavior.run("fetch user", 500)));
            StructuredTaskScope.Subtask<String> account = scope
                    .fork(() -> executeExternalCall(Behavior.fail("fetch account", 500)));

            Stream<StructuredTaskScope.Subtask<Object>> join = scope.join();
            join.forEach(System.out::println); //Exception on previous line, otherwise, if success it will have the result from both call

            System.out.println(formatResults(users, account));
        }
    }

    void handleAwaitAll() throws Exception {
        try (var scope = StructuredTaskScope.open(StructuredTaskScope.Joiner.awaitAll())) {
            StructuredTaskScope.Subtask<String> users = scope
                    .fork(() -> executeExternalCall(Behavior.run("fetch user", 500)));
            StructuredTaskScope.Subtask<String> account = scope
                    .fork(() -> executeExternalCall(Behavior.fail("fetch account", 500)));

            Void join = scope.join();

            System.out.println(formatResults(users, account));
        }
    }

    void handleWithConfigurationTimeout() throws Exception {
        try (var scope = StructuredTaskScope.open(StructuredTaskScope.Joiner.awaitAllSuccessfulOrThrow(),
                cf -> cf.withTimeout(Duration.ofMillis(550)))) {
            //The timeout starts counting from the moment the scope is opened, not when join() is called. This means the timeout covers the entire lifecycle of the scope.
            StructuredTaskScope.Subtask<String> users = scope
                    .fork(() -> executeExternalCall(Behavior.run("fetch user", 500)));
            StructuredTaskScope.Subtask<String> account = scope
                    .fork(() -> executeExternalCall(Behavior.run("fetch account", 500)));

            Void join = scope.join();

            System.out.println(formatResults(users, account));
        }
    }

    void handleCustomJoiner() throws Exception {
        try (var scope = StructuredTaskScope.open(new SeventyFivePercentJoiner<String>())) {
            StructuredTaskScope.Subtask<String> users = scope
                    .fork(() -> executeExternalCall(Behavior.run("fetch user", 500)));
            StructuredTaskScope.Subtask<String> account = scope
                    .fork(() -> executeExternalCall(Behavior.run("fetch account", 500)));

            List<String> join = scope.join();
            join.forEach(System.out::println);

            System.out.println(formatResults(users, account));
        }
    }

    private String executeExternalCall(Behavior behavior) throws InterruptedException {
        String message = behavior.message;
        log("Initialize - " + message);
        if (behavior.failed) {
            log("Ending with Error - " + message);
            throw new CustomException("Internal Error from outside call");
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

    public class CustomException extends RuntimeException {

        public CustomException(String message) {
            super(message);
        }
    }

}