package com.google.android.play.core.splitinstall;

import java.util.concurrent.atomic.AtomicReference;
/* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
public final class w extends Enum<w> implements c {
    public static final w a = new w("INSTANCE");
    public static final AtomicReference<d> b = new AtomicReference<>(null);

    public w(String str) {
    }

    @Override // com.google.android.play.core.splitinstall.c
    public final d a() {
        return b.get();
    }

    public final void a(d dVar) {
        b.compareAndSet(null, dVar);
    }
}
