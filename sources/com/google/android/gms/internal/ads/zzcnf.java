package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
public final class zzcnf implements zzelo<zzbys<zzbvj>> {
    private final zzelx<Executor> zzerr;
    private final zzelx<zzcou> zzfmx;

    private zzcnf(zzelx<zzcou> zzelx, zzelx<Executor> zzelx2) {
        this.zzfmx = zzelx;
        this.zzerr = zzelx2;
    }

    public static zzcnf zzao(zzelx<zzcou> zzelx, zzelx<Executor> zzelx2) {
        return new zzcnf(zzelx, zzelx2);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return (zzbys) zzelu.zza(new zzbys(this.zzfmx.get(), this.zzerr.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
