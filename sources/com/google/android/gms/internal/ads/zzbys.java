package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
public final class zzbys<T> {
    public Executor executor;
    public T zzfum;

    public zzbys(T t, Executor executor2) {
        this.zzfum = t;
        this.executor = executor2;
    }

    public static <T> zzbys<T> zzb(T t, Executor executor2) {
        return new zzbys<>(t, executor2);
    }
}
