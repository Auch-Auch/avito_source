package com.google.android.gms.internal.ads;

import java.util.Objects;
public final class zzcwj implements zzelo<zzcwh> {
    private final zzcwh zzgpe;

    private zzcwj(zzcwh zzcwh) {
        this.zzgpe = zzcwh;
    }

    public static zzcwj zzc(zzcwh zzcwh) {
        return new zzcwj(zzcwh);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        zzcwh zzcwh = this.zzgpe;
        Objects.requireNonNull(zzcwh);
        return (zzcwh) zzelu.zza(zzcwh, "Cannot return null from a non-@Nullable @Provides method");
    }
}
