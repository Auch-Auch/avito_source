package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
public class zzdvc<V> extends zzdvp<V> {
    public static <V> zzdvc<V> zzg(zzdvt<V> zzdvt) {
        if (zzdvt instanceof zzdvc) {
            return (zzdvc) zzdvt;
        }
        return new zzdve(zzdvt);
    }

    public final <X extends Throwable> zzdvc<V> zza(Class<X> cls, zzdsl<? super X, ? extends V> zzdsl, Executor executor) {
        zzduj zzduj = new zzduj(this, cls, zzdsl);
        addListener(zzduj, zzdvv.zza(executor, zzduj));
        return zzduj;
    }

    public final <T> zzdvc<T> zzb(zzduv<? super V, T> zzduv, Executor executor) {
        zzdsv.checkNotNull(executor);
        zzdun zzdun = new zzdun(this, zzduv);
        addListener(zzdun, zzdvv.zza(executor, zzdun));
        return zzdun;
    }

    public final <X extends Throwable> zzdvc<V> zza(Class<X> cls, zzduv<? super X, ? extends V> zzduv, Executor executor) {
        zzdug zzdug = new zzdug(this, cls, zzduv);
        addListener(zzdug, zzdvv.zza(executor, zzdug));
        return zzdug;
    }

    public final zzdvc<V> zza(long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        return (zzdvc) zzdvl.zza(this, j, timeUnit, scheduledExecutorService);
    }

    public final <T> zzdvc<T> zza(zzdsl<? super V, T> zzdsl, Executor executor) {
        zzdsv.checkNotNull(zzdsl);
        zzdum zzdum = new zzdum(this, zzdsl);
        addListener(zzdum, zzdvv.zza(executor, zzdum));
        return zzdum;
    }
}
