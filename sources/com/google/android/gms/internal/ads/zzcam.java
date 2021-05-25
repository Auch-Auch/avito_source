package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;
public final class zzcam implements zzelo<Set<zzbys<zzbyl>>> {
    private final zzelx<zzcbd> zzfnr;

    private zzcam(zzelx<zzcbd> zzelx) {
        this.zzfnr = zzelx;
    }

    public static zzcam zzw(zzelx<zzcbd> zzelx) {
        return new zzcam(zzelx);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return (Set) zzelu.zza(Collections.singleton(zzbys.zzb(this.zzfnr.get(), zzbbi.zzedz)), "Cannot return null from a non-@Nullable @Provides method");
    }
}
