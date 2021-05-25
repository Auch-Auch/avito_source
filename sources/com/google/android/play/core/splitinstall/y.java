package com.google.android.play.core.splitinstall;

import java.util.concurrent.atomic.AtomicReference;
public final class y {
    public static final AtomicReference<x> a = new AtomicReference<>(null);

    public static void a(x xVar) {
        a.compareAndSet(null, xVar);
    }
}
