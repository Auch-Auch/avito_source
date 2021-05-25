package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
public final class zzdvm<V> {
    private final boolean zzhpb;
    private final zzdtg<zzdvt<? extends V>> zzhpt;

    private zzdvm(boolean z, zzdtg<zzdvt<? extends V>> zzdtg) {
        this.zzhpb = z;
        this.zzhpt = zzdtg;
    }

    public final <C> zzdvt<C> zza(Callable<C> callable, Executor executor) {
        return new zzduz(this.zzhpt, this.zzhpb, executor, callable);
    }

    public /* synthetic */ zzdvm(boolean z, zzdtg zzdtg, zzdvk zzdvk) {
        this(z, zzdtg);
    }
}
