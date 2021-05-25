package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
public abstract class zzdvg<V> extends zzdvh<V> implements zzdvt<V> {
    @Override // com.google.android.gms.internal.ads.zzdvt
    public void addListener(Runnable runnable, Executor executor) {
        zzaxl().addListener(runnable, executor);
    }

    /* renamed from: zzaxk */
    public abstract zzdvt<? extends V> zzaxl();
}
