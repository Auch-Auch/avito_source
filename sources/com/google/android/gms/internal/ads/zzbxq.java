package com.google.android.gms.internal.ads;

import java.util.Set;
public final class zzbxq implements zzelo<Set<zzbys<zzut>>> {
    private final zzbxj zzfug;

    private zzbxq(zzbxj zzbxj) {
        this.zzfug = zzbxj;
    }

    public static zzbxq zzm(zzbxj zzbxj) {
        return new zzbxq(zzbxj);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return (Set) zzelu.zza(this.zzfug.zzajz(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
