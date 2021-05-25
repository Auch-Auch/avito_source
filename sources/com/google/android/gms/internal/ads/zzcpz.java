package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.HashMap;
import java.util.concurrent.Executor;
public final class zzcpz implements zzelo<zzcpj> {
    private final zzelx<Context> zzert;
    private final zzelx<Executor> zzfol;
    private final zzelx<zzatc> zzgjk;
    private final zzelx<zzble> zzgjl;
    private final zzelx<zzatd> zzgjm;
    private final zzelx<HashMap<String, zzcpy>> zzgjn;

    private zzcpz(zzelx<Context> zzelx, zzelx<Executor> zzelx2, zzelx<zzatc> zzelx3, zzelx<zzble> zzelx4, zzelx<zzatd> zzelx5, zzelx<HashMap<String, zzcpy>> zzelx6) {
        this.zzert = zzelx;
        this.zzfol = zzelx2;
        this.zzgjk = zzelx3;
        this.zzgjl = zzelx4;
        this.zzgjm = zzelx5;
        this.zzgjn = zzelx6;
    }

    public static zzcpz zza(zzelx<Context> zzelx, zzelx<Executor> zzelx2, zzelx<zzatc> zzelx3, zzelx<zzble> zzelx4, zzelx<zzatd> zzelx5, zzelx<HashMap<String, zzcpy>> zzelx6) {
        return new zzcpz(zzelx, zzelx2, zzelx3, zzelx4, zzelx5, zzelx6);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzcpj(this.zzert.get(), this.zzfol.get(), this.zzgjk.get(), this.zzgjl.get(), this.zzgjm.get(), this.zzgjn.get());
    }
}
