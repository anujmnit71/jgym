package io.jgym.warmups.day20;

import java.math.*;
import java.util.concurrent.*;
import java.util.function.*;

public class FactorialParallelDemo {
    // https://www.javaspecialists.eu/courses/blackfriday20
    public static void main(String... args) {
        for (int i = 0; i < 5; i++) {
            test();
        }
    }

    private static void test() {
        long time = System.nanoTime();
        try {
            BigInteger result = factorial(1_000_000);
            System.out.println("result.bitCount() = " + result.bitCount());
        } finally {
            time = System.nanoTime() - time;
            System.out.printf("time = %dms%n", (time / 1_000_000));
        }
    }

    private static BigInteger factorial(int n) {
        return factorial(0, n);
    }

    private static BigInteger factorial(int from, int to) {
        if (from == to) {
            if (from == 0) return BigInteger.ONE;
            return BigInteger.valueOf(from);
        }
        int mid = (from + to) >>> 1;
        return factorial(from, mid).multiply(factorial(mid+1, to));
    }
}
