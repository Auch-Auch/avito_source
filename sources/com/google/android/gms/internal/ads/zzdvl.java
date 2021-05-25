package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdvq;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public final class zzdvl extends zzdvo {
    public static <V> zzdvt<V> immediateFailedFuture(Throwable th) {
        zzdsv.checkNotNull(th);
        return new zzdvq.zza(th);
    }

    public static <O> zzdvt<O> zza(zzdut<O> zzdut, Executor executor) {
        zzdwh zzdwh = new zzdwh(zzdut);
        executor.execute(zzdwh);
        return zzdwh;
    }

    public static <V> zzdvt<V> zzaf(@NullableDecl V v) {
        return v == null ? (zzdvt<V>) zzdvq.zzhpw : new zzdvq(v);
    }

    public static <V, X extends Throwable> zzdvt<V> zzb(zzdvt<? extends V> zzdvt, Class<X> cls, zzduv<? super X, ? extends V> zzduv, Executor executor) {
        return zzduh.zza(zzdvt, cls, zzduv, executor);
    }

    public static <V> zzdvt<List<V>> zzi(Iterable<? extends zzdvt<? extends V>> iterable) {
        return new zzdux(zzdtg.zzh(iterable), true);
    }

    public static <V> zzdvm<V> zzj(Iterable<? extends zzdvt<? extends V>> iterable) {
        return new zzdvm<>(false, zzdtg.zzh(iterable), null);
    }

    public static <V> zzdvm<V> zzk(Iterable<? extends zzdvt<? extends V>> iterable) {
        return new zzdvm<>(true, zzdtg.zzh(iterable), null);
    }

    public static <I, O> zzdvt<O> zzb(zzdvt<I> zzdvt, zzduv<? super I, ? extends O> zzduv, Executor executor) {
        return zzduk.zza(zzdvt, zzduv, executor);
    }

    public static <V> zzdvt<V> zza(zzdvt<V> zzdvt, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        if (zzdvt.isDone()) {
            return zzdvt;
        }
        return zzdwd.zzb(zzdvt, j, timeUnit, scheduledExecutorService);
    }

    public static <I, O> zzdvt<O> zzb(zzdvt<I> zzdvt, zzdsl<? super I, ? extends O> zzdsl, Executor executor) {
        return zzduk.zza(zzdvt, zzdsl, executor);
    }

    @SafeVarargs
    public static <V> zzdvm<V> zzb(zzdvt<? extends V>... zzdvtArr) {
        return new zzdvm<>(true, zzdtg.zzb(zzdvtArr), null);
    }

    @SafeVarargs
    public static <V> zzdvm<V> zza(zzdvt<? extends V>... zzdvtArr) {
        return new zzdvm<>(false, zzdtg.zzb(zzdvtArr), null);
    }

    public static <V> V zzb(Future<V> future) {
        zzdsv.checkNotNull(future);
        try {
            return (V) zzdwl.getUninterruptibly(future);
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause instanceof Error) {
                throw new zzdvd((Error) cause);
            }
            throw new zzdwm(cause);
        }
    }

    public static <V> void zza(zzdvt<V> zzdvt, zzdvi<? super V> zzdvi, Executor executor) {
        zzdsv.checkNotNull(zzdvi);
        zzdvt.addListener(new zzdvn(zzdvt, zzdvi), executor);
    }

    public static <V> V zza(Future<V> future) throws ExecutionException {
        if (future.isDone()) {
            return (V) zzdwl.getUninterruptibly(future);
        }
        throw new IllegalStateException(zzdsw.zzb("Future was expected to be done: %s", future));
    }
}
