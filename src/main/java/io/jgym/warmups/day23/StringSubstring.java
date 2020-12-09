package io.jgym.warmups.day23;

import io.jgym.warmups.day18.*;

import java.util.concurrent.*;

public class StringSubstring {
    private static Object leak;

    public static void main(String... args) throws Exception {
        ByteWatcherSingleThread bw = new ByteWatcherSingleThread();
        final String song = "Mary had a little lamb,\n" +
                            "little lamb, little lamb,\n" +
                            "Mary had a little lamb,\n" +
                            "it's fleece was white as snow.\n";

        Callable<?> creator = new Callable<Object>() {
            public Object call() throws Exception {
                return song.substring(0, 4);
            }
        };

        leak = creator.call();

        bw.reset();
        leak = creator.call();
        long bytes = bw.calculateAllocations();

        System.out.println("bytes = " + bytes);
    }
}
