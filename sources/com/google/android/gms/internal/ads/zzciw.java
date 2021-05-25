package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zza;
import java.util.concurrent.Executor;
public final class zzciw implements zzelo<zzcij> {
    private final zzelx<Executor> zzerr;
    private final zzelx<zzbma> zzeuq;
    private final zzelx<zzbtu> zzevd;
    private final zzelx<zzbst> zzevh;
    private final zzelx<zzbur> zzewj;
    private final zzelx<zzbyr> zzexd;
    private final zzelx<zzbws> zzfdx;
    private final zzelx<zzbui> zzfef;
    private final zzelx<zzbwl> zzffy;
    private final zzelx<zzavu> zzfrh;
    private final zzelx<zzeg> zzfwp;
    private final zzelx<zza> zzgdp;
    private final zzelx<zzbto> zzgdq;

    private zzciw(zzelx<zzbst> zzelx, zzelx<zzbtu> zzelx2, zzelx<zzbui> zzelx3, zzelx<zzbur> zzelx4, zzelx<zzbws> zzelx5, zzelx<Executor> zzelx6, zzelx<zzbyr> zzelx7, zzelx<zzbma> zzelx8, zzelx<zza> zzelx9, zzelx<zzbto> zzelx10, zzelx<zzavu> zzelx11, zzelx<zzeg> zzelx12, zzelx<zzbwl> zzelx13) {
        this.zzevh = zzelx;
        this.zzevd = zzelx2;
        this.zzfef = zzelx3;
        this.zzewj = zzelx4;
        this.zzfdx = zzelx5;
        this.zzerr = zzelx6;
        this.zzexd = zzelx7;
        this.zzeuq = zzelx8;
        this.zzgdp = zzelx9;
        this.zzgdq = zzelx10;
        this.zzfrh = zzelx11;
        this.zzfwp = zzelx12;
        this.zzffy = zzelx13;
    }

    public static zzciw zza(zzelx<zzbst> zzelx, zzelx<zzbtu> zzelx2, zzelx<zzbui> zzelx3, zzelx<zzbur> zzelx4, zzelx<zzbws> zzelx5, zzelx<Executor> zzelx6, zzelx<zzbyr> zzelx7, zzelx<zzbma> zzelx8, zzelx<zza> zzelx9, zzelx<zzbto> zzelx10, zzelx<zzavu> zzelx11, zzelx<zzeg> zzelx12, zzelx<zzbwl> zzelx13) {
        return new zzciw(zzelx, zzelx2, zzelx3, zzelx4, zzelx5, zzelx6, zzelx7, zzelx8, zzelx9, zzelx10, zzelx11, zzelx12, zzelx13);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzcij(this.zzevh.get(), this.zzevd.get(), this.zzfef.get(), this.zzewj.get(), this.zzfdx.get(), this.zzerr.get(), this.zzexd.get(), this.zzeuq.get(), this.zzgdp.get(), this.zzgdq.get(), this.zzfrh.get(), this.zzfwp.get(), this.zzffy.get());
    }
}
