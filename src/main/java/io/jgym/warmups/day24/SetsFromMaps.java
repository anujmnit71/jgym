package io.jgym.warmups.day24;

import java.util.*;
import java.util.concurrent.*;

public class SetsFromMaps {
    public static void main(String... args) {
        Set<?>[] sets = {
                new ConcurrentSkipListSet<>(), // Java 6
                new CopyOnWriteArraySet<>(), // Java 5
                new HashSet<>(), // Java 2
                new LinkedHashSet<>(), // Java 4
                new TreeSet<>(), // Java 2
                EnumSet.allOf(Thread.State.class), // Java 5
                ConcurrentHashMap.newKeySet(), // since Java 8
                Collections.newSetFromMap(new ConcurrentHashMap<>()), // Java 6
        };

        Map<?, ?>[] maps = {
                new ConcurrentHashMap<>(), // Java 5
                new Hashtable<>(), // Java 1.0
                new IdentityHashMap<>(), // Java 4
                new WeakHashMap<>() // Java 2
        };
    }
}
