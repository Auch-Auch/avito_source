package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
public final class zzcak implements zzelo<zzbys<zzbsu>> {
    private final zzelx<Executor> zzerr;
    private final zzelx<zzcbf> zzfnr;
    private final zzbzw zzfva;

    private zzcak(zzbzw zzbzw, zzelx<zzcbf> zzelx, zzelx<Executor> zzelx2) {
        this.zzfva = zzbzw;
        this.zzfnr = zzelx;
        this.zzerr = zzelx2;
    }

    public static zzcak zzb(zzbzw zzbzw, zzelx<zzcbf> zzelx, zzelx<Executor> zzelx2) {
        return new zzcak(zzbzw, zzelx, zzelx2);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return (zzbys) zzelu.zza(new zzbys(this.zzfnr.get(), this.zzerr.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
