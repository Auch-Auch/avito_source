package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
public final class zzduy extends zzdvb<V> {
    private final Callable<V> zzhpl;
    private final /* synthetic */ zzduz zzhpm;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzduy(zzduz zzduz, Callable<V> callable, Executor executor) {
        super(zzduz, executor);
        this.zzhpm = zzduz;
        this.zzhpl = (Callable) zzdsv.checkNotNull(callable);
    }

    @Override // com.google.android.gms.internal.ads.zzdvb
    public final void setValue(V v) {
        this.zzhpm.set(v);
    }

    @Override // com.google.android.gms.internal.ads.zzdvs
    public final V zzaxi() throws Exception {
        this.zzhpr = false;
        return this.zzhpl.call();
    }

    @Override // com.google.android.gms.internal.ads.zzdvs
    public final String zzaxj() {
        return this.zzhpl.toString();
    }
}
