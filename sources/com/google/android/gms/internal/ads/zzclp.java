package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
public final class zzclp implements zzelo<zzcln> {
    private final zzelx<Executor> zzerr;
    private final zzelx<Context> zzert;
    private final zzelx<zzbbh> zzfbu;
    private final zzelx<zzbbg> zzfkr;

    public zzclp(zzelx<Executor> zzelx, zzelx<zzbbh> zzelx2, zzelx<Context> zzelx3, zzelx<zzbbg> zzelx4) {
        this.zzerr = zzelx;
        this.zzfbu = zzelx2;
        this.zzert = zzelx3;
        this.zzfkr = zzelx4;
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzcln(this.zzerr.get(), this.zzfbu.get(), this.zzert.get(), this.zzfkr.get());
    }
}
