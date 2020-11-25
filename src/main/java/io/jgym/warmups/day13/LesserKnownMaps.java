package io.jgym.warmups.day13;

import java.util.*;
import java.util.concurrent.*;

public class LesserKnownMaps {
    public static void main(String... args) {
        Map<?, ?>[] maps = {
                new ConcurrentSkipListMap<>(),
                new EnumMap<>(Thread.State.class),
                new LinkedHashMap<>(),
                new IdentityHashMap<>(),
                new WeakHashMap<>()
        };
    }
}
