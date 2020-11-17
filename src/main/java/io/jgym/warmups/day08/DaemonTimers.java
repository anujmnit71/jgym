package io.jgym.warmups.day08;

import java.util.*;
import java.util.concurrent.*;

public class DaemonTimers {
    public static void main(String... args) throws InterruptedException {
    }

    public static void showDaemonStatus() {
        System.out.println("Thread " + Thread.currentThread().getName() + " is " +
                (Thread.currentThread().isDaemon() ? "" : "not ") + "a daemon thread");
    }
}
