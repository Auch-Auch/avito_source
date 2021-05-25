package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Callable;
/* JADX WARN: Field signature parse error: zzhgq */
public final class zzdot {
    private final Object zzhgq;
    private final List<zzdvt<?>> zzhgt;
    private final /* synthetic */ zzdor zzhgu;

    private zzdot(zzdor zzdor, E e, List<zzdvt<?>> list) {
        this.zzhgu = zzdor;
        this.zzhgq = e;
        this.zzhgt = list;
    }

    public final <O> zzdox<O> zzb(Callable<O> callable) {
        zzdvm zzk = zzdvl.zzk(this.zzhgt);
        zzdvt zza = zzk.zza(zzdow.zzgtz, zzbbi.zzedz);
        zzdor zzdor = this.zzhgu;
        return new zzdox<>(zzdor, this.zzhgq, zza, this.zzhgt, zzk.zza(callable, zzdor.zzgay));
    }
}
