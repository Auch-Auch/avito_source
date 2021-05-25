package com.google.android.gms.internal.ads;

import java.util.Set;
public final class zzbxr implements zzelo<Set<zzbys<zzbtm>>> {
    private final zzbxj zzfug;

    private zzbxr(zzbxj zzbxj) {
        this.zzfug = zzbxj;
    }

    public static zzbxr zzn(zzbxj zzbxj) {
        return new zzbxr(zzbxj);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return (Set) zzelu.zza(this.zzfug.zzaka(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
