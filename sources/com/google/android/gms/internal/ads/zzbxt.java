package com.google.android.gms.internal.ads;

import java.util.Set;
public final class zzbxt implements zzelo<Set<zzbys<zzbuj>>> {
    private final zzbxj zzfug;

    private zzbxt(zzbxj zzbxj) {
        this.zzfug = zzbxj;
    }

    public static zzbxt zzp(zzbxj zzbxj) {
        return new zzbxt(zzbxj);
    }

    public static Set<zzbys<zzbuj>> zzq(zzbxj zzbxj) {
        return (Set) zzelu.zza(zzbxj.zzaju(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return zzq(this.zzfug);
    }
}
