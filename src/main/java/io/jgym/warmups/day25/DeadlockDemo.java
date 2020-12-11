package io.jgym.warmups.day25;

import java.util.concurrent.*;

public class DeadlockDemo {
    private static final int REPEATS = 1000;

    public static void main(String... args) throws InterruptedException {
        BankAccount fnb = new BankAccount(1000);
        BankAccount absa = new BankAccount(1000);

        DeadlockTester tester = new DeadlockTester();

        tester.checkThatCodeDoesNotDeadlock(() -> {
            ExecutorService pool = Executors.newFixedThreadPool(2);
            Future<?> transfer1 = pool.submit(() -> {
                for (int i = 0; i < REPEATS; i++) {
                    fnb.transferTo(absa, 100);
                }
            });
            Future<?> transfer2 = pool.submit(() ->
            {
                for (int i = 0; i < REPEATS; i++) {
                    absa.transferTo(fnb, 100);
                }
            });
            try {
                transfer1.get();
                transfer2.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
            pool.shutdown();
        });
    }
}
