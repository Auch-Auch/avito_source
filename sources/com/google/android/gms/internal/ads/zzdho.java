package com.google.android.gms.internal.ads;

import android.content.Context;
public final class zzdho implements zzelo<zzdhl> {
    private final zzelx<zzbii> zzerp;
    private final zzelx<Context> zzert;
    private final zzelx<zzbbg> zzfnd;
    private final zzelx<String> zzgxn;
    private final zzelx<zzdhc> zzgxo;
    private final zzelx<zzdht> zzgxp;

    public zzdho(zzelx<zzbii> zzelx, zzelx<Context> zzelx2, zzelx<String> zzelx3, zzelx<zzdhc> zzelx4, zzelx<zzdht> zzelx5, zzelx<zzbbg> zzelx6) {
        this.zzerp = zzelx;
        this.zzert = zzelx2;
        this.zzgxn = zzelx3;
        this.zzgxo = zzelx4;
        this.zzgxp = zzelx5;
        this.zzfnd = zzelx6;
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzdhl(this.zzerp.get(), this.zzert.get(), this.zzgxn.get(), this.zzgxo.get(), this.zzgxp.get(), this.zzfnd.get());
    }
}
