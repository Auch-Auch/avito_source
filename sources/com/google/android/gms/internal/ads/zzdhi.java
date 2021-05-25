package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
public final class zzdhi implements zzelo<zzdhc> {
    private final zzelx<zzbii> zzerp;
    private final zzelx<Executor> zzfol;
    private final zzelx<Context> zzgxc;
    private final zzelx<zzdiz<zzbmw, zzbnc>> zzgxd;
    private final zzelx<zzdht> zzgxe;
    private final zzelx<zzdlp> zzgxf;

    public zzdhi(zzelx<Context> zzelx, zzelx<Executor> zzelx2, zzelx<zzbii> zzelx3, zzelx<zzdiz<zzbmw, zzbnc>> zzelx4, zzelx<zzdht> zzelx5, zzelx<zzdlp> zzelx6) {
        this.zzgxc = zzelx;
        this.zzfol = zzelx2;
        this.zzerp = zzelx3;
        this.zzgxd = zzelx4;
        this.zzgxe = zzelx5;
        this.zzgxf = zzelx6;
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzdhc(this.zzgxc.get(), this.zzfol.get(), this.zzerp.get(), this.zzgxd.get(), this.zzgxe.get(), this.zzgxf.get());
    }
}
