package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzp;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.ParametersAreNonnullByDefault;
@ParametersAreNonnullByDefault
public class zzbbq<T> implements zzdvt<T> {
    private final zzdwe<T> zzeee = zzdwe.zzaxn();

    private static boolean zzas(boolean z) {
        if (!z) {
            zzp.zzkt().zzb(new IllegalStateException("Provided SettableFuture with multiple values."), "SettableFuture");
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzdvt
    public void addListener(Runnable runnable, Executor executor) {
        this.zzeee.addListener(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        return this.zzeee.cancel(z);
    }

    @Override // java.util.concurrent.Future
    public T get() throws ExecutionException, InterruptedException {
        return this.zzeee.get();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.zzeee.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.zzeee.isDone();
    }

    public final boolean set(@Nullable T t) {
        return zzas(this.zzeee.set(t));
    }

    public final boolean setException(Throwable th) {
        return zzas(this.zzeee.setException(th));
    }

    @Override // java.util.concurrent.Future
    public T get(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return this.zzeee.get(j, timeUnit);
    }
}
