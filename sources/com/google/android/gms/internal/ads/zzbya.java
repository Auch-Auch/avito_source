package com.google.android.gms.internal.ads;

import java.util.Objects;
public final class zzbya implements zzelo<zzbxj> {
    private final zzbxj zzfug;

    private zzbya(zzbxj zzbxj) {
        this.zzfug = zzbxj;
    }

    public static zzbya zzx(zzbxj zzbxj) {
        return new zzbya(zzbxj);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        zzbxj zzbxj = this.zzfug;
        Objects.requireNonNull(zzbxj);
        return (zzbxj) zzelu.zza(zzbxj, "Cannot return null from a non-@Nullable @Provides method");
    }
}
