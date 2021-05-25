package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;
public final class zzbzz implements zzelo<Set<zzbys<zzbwt>>> {
    private final zzelx<zzbru> zzfnr;
    private final zzbzw zzfva;

    private zzbzz(zzbzw zzbzw, zzelx<zzbru> zzelx) {
        this.zzfva = zzbzw;
        this.zzfnr = zzelx;
    }

    public static zzbzz zzb(zzbzw zzbzw, zzelx<zzbru> zzelx) {
        return new zzbzz(zzbzw, zzelx);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return (Set) zzelu.zza(Collections.singleton(zzbys.zzb(this.zzfnr.get(), zzbbi.zzedz)), "Cannot return null from a non-@Nullable @Provides method");
    }
}
