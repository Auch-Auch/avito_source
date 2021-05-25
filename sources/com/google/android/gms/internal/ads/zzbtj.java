package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;
public final class zzbtj implements zzelo<zzbtb> {
    private final zzelx<Executor> zzerr;
    private final zzelx<zzbtf> zzews;
    private final zzelx<Set<zzbys<zzbsy>>> zzfor;

    private zzbtj(zzelx<zzbtf> zzelx, zzelx<Set<zzbys<zzbsy>>> zzelx2, zzelx<Executor> zzelx3) {
        this.zzews = zzelx;
        this.zzfor = zzelx2;
        this.zzerr = zzelx3;
    }

    public static zzbtj zzi(zzelx<zzbtf> zzelx, zzelx<Set<zzbys<zzbsy>>> zzelx2, zzelx<Executor> zzelx3) {
        return new zzbtj(zzelx, zzelx2, zzelx3);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzbtb(this.zzews.get(), this.zzfor.get(), this.zzerr.get());
    }
}
