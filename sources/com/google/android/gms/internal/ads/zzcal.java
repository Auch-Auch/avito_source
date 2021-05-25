package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
public final class zzcal implements zzelo<zzbys<zzbwm>> {
    private final zzelx<Executor> zzerr;
    private final zzbzw zzfva;

    private zzcal(zzbzw zzbzw, zzelx<Executor> zzelx) {
        this.zzfva = zzbzw;
        this.zzerr = zzelx;
    }

    public static zzcal zzf(zzbzw zzbzw, zzelx<Executor> zzelx) {
        return new zzcal(zzbzw, zzelx);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return (zzbys) zzelu.zza(this.zzfva.zzb(this.zzerr.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
