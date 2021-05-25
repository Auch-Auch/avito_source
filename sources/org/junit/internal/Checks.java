package org.junit.internal;

import java.util.Objects;
public final class Checks {
    public static <T> T notNull(T t) {
        Objects.requireNonNull(t);
        return t;
    }

    public static <T> T notNull(T t, String str) {
        Objects.requireNonNull(t, str);
        return t;
    }
}
