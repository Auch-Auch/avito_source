package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
public final class zzcgm implements zzelo<zzcgf> {
    private final zzelx<Executor> zzfol;
    private final zzelx<zzbmj> zzgad;
    private final zzelx<zzbyr> zzgcc;

    public zzcgm(zzelx<Executor> zzelx, zzelx<zzbmj> zzelx2, zzelx<zzbyr> zzelx3) {
        this.zzfol = zzelx;
        this.zzgad = zzelx2;
        this.zzgcc = zzelx3;
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzcgf(this.zzfol.get(), this.zzgad.get(), this.zzgcc.get());
    }
}
