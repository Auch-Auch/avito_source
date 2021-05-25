package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicInteger;
@Deprecated
public class zzbbx<T> {
    private final zzbbq<T> zzeeh;
    private final AtomicInteger zzeei = new AtomicInteger(0);

    public zzbbx() {
        zzbbq<T> zzbbq = new zzbbq<>();
        this.zzeeh = zzbbq;
        zzdvl.zza(zzbbq, new zzbbw(this), zzbbi.zzedz);
    }

    @Deprecated
    public final int getStatus() {
        return this.zzeei.get();
    }

    @Deprecated
    public final void reject() {
        this.zzeeh.setException(new Exception());
    }

    @Deprecated
    public final void zza(zzbbu<T> zzbbu, zzbbs zzbbs) {
        zzdvl.zza(this.zzeeh, new zzbbz(this, zzbbu, zzbbs), zzbbi.zzedz);
    }

    @Deprecated
    public final void zzm(T t) {
        this.zzeeh.set(t);
    }
}
