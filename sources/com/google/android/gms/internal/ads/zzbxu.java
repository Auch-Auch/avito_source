package com.google.android.gms.internal.ads;

import java.util.Set;
public final class zzbxu implements zzelo<Set<zzbys<zzbsu>>> {
    private final zzbxj zzfug;

    private zzbxu(zzbxj zzbxj) {
        this.zzfug = zzbxj;
    }

    public static zzbxu zzr(zzbxj zzbxj) {
        return new zzbxu(zzbxj);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return (Set) zzelu.zza(this.zzfug.zzajt(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
