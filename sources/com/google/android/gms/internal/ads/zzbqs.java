package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
public final class zzbqs implements zzelo<zzbys<zzbyx>> {
    private final zzelx<Executor> zzerr;
    private final zzelx<zzbza> zzfnr;

    private zzbqs(zzelx<zzbza> zzelx, zzelx<Executor> zzelx2) {
        this.zzfnr = zzelx;
        this.zzerr = zzelx2;
    }

    public static zzbqs zzf(zzelx<zzbza> zzelx, zzelx<Executor> zzelx2) {
        return new zzbqs(zzelx, zzelx2);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return (zzbys) zzelu.zza(new zzbys(this.zzfnr.get(), this.zzerr.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
