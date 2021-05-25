package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;
public final class zzbnx implements zzelo<Set<zzbys<zzqu>>> {
    private final zzelx<zzboy> zzfnr;
    private final zzbnl zzfoq;

    public zzbnx(zzbnl zzbnl, zzelx<zzboy> zzelx) {
        this.zzfoq = zzbnl;
        this.zzfnr = zzelx;
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return (Set) zzelu.zza(Collections.singleton(new zzbys(this.zzfnr.get(), zzbbi.zzedz)), "Cannot return null from a non-@Nullable @Provides method");
    }
}
