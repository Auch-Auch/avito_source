package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
public final class zzcdv implements zzelo<zzcdr> {
    private final zzelx<Executor> zzerr;
    private final zzelx<zzccz> zzeul;
    private final zzelx<zzcdz> zzexi;
    private final zzelx<zzceh> zzexj;
    private final zzelx<zzccu> zzexl;
    private final zzelx<zzaya> zzeyo;
    private final zzelx<Executor> zzfol;
    private final zzelx<zzdln> zzfos;
    private final zzelx<zzccv> zzfwo;

    private zzcdv(zzelx<zzaya> zzelx, zzelx<zzdln> zzelx2, zzelx<zzccz> zzelx3, zzelx<zzccv> zzelx4, zzelx<zzcdz> zzelx5, zzelx<zzceh> zzelx6, zzelx<Executor> zzelx7, zzelx<Executor> zzelx8, zzelx<zzccu> zzelx9) {
        this.zzeyo = zzelx;
        this.zzfos = zzelx2;
        this.zzeul = zzelx3;
        this.zzfwo = zzelx4;
        this.zzexi = zzelx5;
        this.zzexj = zzelx6;
        this.zzfol = zzelx7;
        this.zzerr = zzelx8;
        this.zzexl = zzelx9;
    }

    public static zzcdv zza(zzelx<zzaya> zzelx, zzelx<zzdln> zzelx2, zzelx<zzccz> zzelx3, zzelx<zzccv> zzelx4, zzelx<zzcdz> zzelx5, zzelx<zzceh> zzelx6, zzelx<Executor> zzelx7, zzelx<Executor> zzelx8, zzelx<zzccu> zzelx9) {
        return new zzcdv(zzelx, zzelx2, zzelx3, zzelx4, zzelx5, zzelx6, zzelx7, zzelx8, zzelx9);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzcdr(this.zzeyo.get(), this.zzfos.get(), this.zzeul.get(), this.zzfwo.get(), this.zzexi.get(), this.zzexj.get(), this.zzfol.get(), this.zzerr.get(), this.zzexl.get());
    }
}
