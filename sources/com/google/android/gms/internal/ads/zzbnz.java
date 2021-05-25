package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
public final class zzbnz implements zzelo<zzbys<zzqu>> {
    private final zzelx<Executor> zzerr;
    private final zzelx<zzbpc> zzfnr;
    private final zzbnl zzfoq;

    public zzbnz(zzbnl zzbnl, zzelx<zzbpc> zzelx, zzelx<Executor> zzelx2) {
        this.zzfoq = zzbnl;
        this.zzfnr = zzelx;
        this.zzerr = zzelx2;
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return (zzbys) zzelu.zza(new zzbys(this.zzfnr.get(), this.zzerr.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
