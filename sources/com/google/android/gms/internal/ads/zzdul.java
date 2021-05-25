package com.google.android.gms.internal.ads;

import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RunnableFuture;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public abstract class zzdul extends AbstractExecutorService implements zzdvw {
    @Override // java.util.concurrent.AbstractExecutorService
    public final <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        return zzdwh.zza(runnable, t);
    }

    @Override // com.google.android.gms.internal.ads.zzdvw
    /* renamed from: zze */
    public final <T> zzdvt<T> submit(Callable<T> callable) {
        return (zzdvt) super.submit(callable);
    }

    @Override // com.google.android.gms.internal.ads.zzdvw
    /* renamed from: zzf */
    public final zzdvt<?> submit(Runnable runnable) {
        return (zzdvt) super.submit(runnable);
    }

    @Override // java.util.concurrent.AbstractExecutorService
    public final <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return zzdwh.zzf(callable);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public /* synthetic */ Future submit(Runnable runnable, @NullableDecl Object obj) {
        return (zzdvt) super.submit(runnable, obj);
    }
}
