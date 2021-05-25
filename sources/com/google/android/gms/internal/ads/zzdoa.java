package com.google.android.gms.internal.ads;

import a2.b.a.a.a;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
public final class zzdoa implements ThreadFactory {
    private final AtomicInteger zzzm = new AtomicInteger(1);

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, a.m2(25, "AdWorker(NG) #", this.zzzm.getAndIncrement()));
    }
}
