package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;
public final class zzbxm implements zzelo<Set<zzbys<zzbtp>>> {
    private final zzbxj zzfug;

    private zzbxm(zzbxj zzbxj) {
        this.zzfug = zzbxj;
    }

    public static zzbxm zzi(zzbxj zzbxj) {
        return new zzbxm(zzbxj);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return (Set) zzelu.zza(Collections.emptySet(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
