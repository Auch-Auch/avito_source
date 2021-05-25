package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
public final class zzczh implements zzelo<zzczf> {
    private final zzelx<Executor> zzerr;
    private final zzelx<zzcnq> zzghe;

    public zzczh(zzelx<Executor> zzelx, zzelx<zzcnq> zzelx2) {
        this.zzerr = zzelx;
        this.zzghe = zzelx2;
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzczf(this.zzerr.get(), this.zzghe.get());
    }
}
