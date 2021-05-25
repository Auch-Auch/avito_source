package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;
public final class zzbyc implements zzelo<Set<zzbys<zzbyx>>> {
    private final zzbxj zzfug;

    private zzbyc(zzbxj zzbxj) {
        this.zzfug = zzbxj;
    }

    public static zzbyc zzz(zzbxj zzbxj) {
        return new zzbyc(zzbxj);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return (Set) zzelu.zza(Collections.emptySet(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
