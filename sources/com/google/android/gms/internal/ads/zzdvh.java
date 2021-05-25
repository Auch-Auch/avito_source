package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
public abstract class zzdvh<V> extends zzdtd implements Future<V> {
    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        return zzawm().cancel(z);
    }

    @Override // java.util.concurrent.Future
    public V get() throws InterruptedException, ExecutionException {
        return (V) zzawm().get();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return zzawm().isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return zzawm().isDone();
    }

    /* renamed from: zzaxl */
    public abstract Future<? extends V> zzawm();

    @Override // java.util.concurrent.Future
    public V get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return (V) zzawm().get(j, timeUnit);
    }
}
