package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;
public final class zzbxz implements zzelo<Set<zzbys<zzqu>>> {
    private final zzbxj zzfug;

    private zzbxz(zzbxj zzbxj) {
        this.zzfug = zzbxj;
    }

    public static zzbxz zzw(zzbxj zzbxj) {
        return new zzbxz(zzbxj);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return (Set) zzelu.zza(Collections.emptySet(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
