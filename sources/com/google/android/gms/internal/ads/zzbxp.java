package com.google.android.gms.internal.ads;

import java.util.Set;
public final class zzbxp implements zzelo<Set<zzbys<zzbsz>>> {
    private final zzbxj zzfug;

    private zzbxp(zzbxj zzbxj) {
        this.zzfug = zzbxj;
    }

    public static zzbxp zzl(zzbxj zzbxj) {
        return new zzbxp(zzbxj);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return (Set) zzelu.zza(this.zzfug.zzajv(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
