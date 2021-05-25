package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
public final class zzdwj extends zzdvs<V> {
    private final Callable<V> zzhpl;
    private final /* synthetic */ zzdwh zzhqn;

    public zzdwj(zzdwh zzdwh, Callable<V> callable) {
        this.zzhqn = zzdwh;
        this.zzhpl = (Callable) zzdsv.checkNotNull(callable);
    }

    @Override // com.google.android.gms.internal.ads.zzdvs
    public final boolean isDone() {
        return this.zzhqn.isDone();
    }

    @Override // com.google.android.gms.internal.ads.zzdvs
    public final V zzaxi() throws Exception {
        return this.zzhpl.call();
    }

    @Override // com.google.android.gms.internal.ads.zzdvs
    public final String zzaxj() {
        return this.zzhpl.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzdvs
    public final void zzb(V v, Throwable th) {
        if (th == null) {
            this.zzhqn.set(v);
        } else {
            this.zzhqn.setException(th);
        }
    }
}
