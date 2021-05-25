package com.google.android.gms.internal.ads;

import androidx.annotation.VisibleForTesting;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
public final class zzdos<E, V> implements zzdvt<V> {
    private final E zzhgq;
    private final String zzhgr;
    private final zzdvt<V> zzhgs;

    @VisibleForTesting(otherwise = 3)
    public zzdos(E e, String str, zzdvt<V> zzdvt) {
        this.zzhgq = e;
        this.zzhgr = str;
        this.zzhgs = zzdvt;
    }

    @Override // com.google.android.gms.internal.ads.zzdvt
    public final void addListener(Runnable runnable, Executor executor) {
        this.zzhgs.addListener(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        return this.zzhgs.cancel(z);
    }

    @Override // java.util.concurrent.Future
    public final V get() throws InterruptedException, ExecutionException {
        return this.zzhgs.get();
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.zzhgs.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.zzhgs.isDone();
    }

    @Override // java.lang.Object
    public final String toString() {
        String str = this.zzhgr;
        int identityHashCode = System.identityHashCode(this);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12);
        sb.append(str);
        sb.append("@");
        sb.append(identityHashCode);
        return sb.toString();
    }

    public final E zzaux() {
        return this.zzhgq;
    }

    public final String zzauy() {
        return this.zzhgr;
    }

    @Override // java.util.concurrent.Future
    public final V get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.zzhgs.get(j, timeUnit);
    }
}
