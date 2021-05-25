package com.google.android.gms.internal.ads;

import a2.b.a.a.a;
import androidx.annotation.NonNull;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
public final class zzawp implements ThreadFactory {
    private final AtomicInteger zzzm = new AtomicInteger(1);

    public zzawp(zzawb zzawb) {
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(@NonNull Runnable runnable) {
        return new Thread(runnable, a.m2(42, "AdWorker(SCION_TASK_EXECUTOR) #", this.zzzm.getAndIncrement()));
    }
}
