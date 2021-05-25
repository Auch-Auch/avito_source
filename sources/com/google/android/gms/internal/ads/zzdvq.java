package com.google.android.gms.internal.ads;

import a2.b.a.a.a;
import com.google.android.gms.internal.ads.zzdui;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public class zzdvq<V> implements zzdvt<V> {
    private static final Logger zzhoi = Logger.getLogger(zzdvq.class.getName());
    public static final zzdvt<?> zzhpw = new zzdvq(null);
    @NullableDecl
    private final V value;

    public static final class zza<V> extends zzdui.zzj<V> {
        public zza(Throwable th) {
            setException(th);
        }
    }

    public zzdvq(@NullableDecl V v) {
        this.value = v;
    }

    @Override // com.google.android.gms.internal.ads.zzdvt
    public void addListener(Runnable runnable, Executor executor) {
        zzdsv.checkNotNull(runnable, "Runnable was null.");
        zzdsv.checkNotNull(executor, "Executor was null.");
        try {
            executor.execute(runnable);
        } catch (RuntimeException e) {
            Logger logger = zzhoi;
            Level level = Level.SEVERE;
            String valueOf = String.valueOf(runnable);
            String valueOf2 = String.valueOf(executor);
            logger.logp(level, "com.google.common.util.concurrent.ImmediateFuture", "addListener", a.t2(valueOf2.length() + valueOf.length() + 57, "RuntimeException while executing runnable ", valueOf, " with executor ", valueOf2), (Throwable) e);
        }
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        return false;
    }

    @Override // java.util.concurrent.Future
    public V get() {
        return this.value;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return true;
    }

    @Override // java.lang.Object
    public String toString() {
        String obj = super.toString();
        String valueOf = String.valueOf(this.value);
        return a.t2(valueOf.length() + a.q0(obj, 27), obj, "[status=SUCCESS, result=[", valueOf, "]]");
    }

    @Override // java.util.concurrent.Future
    public V get(long j, TimeUnit timeUnit) throws ExecutionException {
        zzdsv.checkNotNull(timeUnit);
        return get();
    }
}
