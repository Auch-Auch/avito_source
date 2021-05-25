package com.google.android.gms.internal.ads;

import java.util.Objects;
public final class zzcbl implements zzelo<zzcbj> {
    private final zzcbj zzfvo;

    private zzcbl(zzcbj zzcbj) {
        this.zzfvo = zzcbj;
    }

    public static zzcbl zzc(zzcbj zzcbj) {
        return new zzcbl(zzcbj);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        zzcbj zzcbj = this.zzfvo;
        Objects.requireNonNull(zzcbj);
        return (zzcbj) zzelu.zza(zzcbj, "Cannot return null from a non-@Nullable @Provides method");
    }
}
