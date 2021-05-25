package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;
public final class zzbmr implements zzelo<Set<zzbys<zzbuj>>> {
    private final zzbmp zzfnq;
    private final zzelx<zzboy> zzfnr;

    public zzbmr(zzbmp zzbmp, zzelx<zzboy> zzelx) {
        this.zzfnq = zzbmp;
        this.zzfnr = zzelx;
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return (Set) zzelu.zza(Collections.singleton(new zzbys(this.zzfnr.get(), zzbbi.zzedz)), "Cannot return null from a non-@Nullable @Provides method");
    }
}
