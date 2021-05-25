package com.google.android.gms.internal.ads;

import android.view.ViewGroup;
import com.google.android.gms.internal.ads.zzbsg;
public final class zzcua implements zzelo<zzctx> {
    private final zzelx<zzbvb> zzfrw;
    private final zzelx<zzbii> zzfwi;
    private final zzelx<zzbsg.zza> zzfwj;
    private final zzelx<zzbxj> zzfwk;
    private final zzelx<zzcbj> zzfwl;
    private final zzelx<zzcwh> zzgna;
    private final zzelx<ViewGroup> zzgnb;

    public zzcua(zzelx<zzbii> zzelx, zzelx<zzbsg.zza> zzelx2, zzelx<zzcwh> zzelx3, zzelx<zzbxj> zzelx4, zzelx<zzcbj> zzelx5, zzelx<zzbvb> zzelx6, zzelx<ViewGroup> zzelx7) {
        this.zzfwi = zzelx;
        this.zzfwj = zzelx2;
        this.zzgna = zzelx3;
        this.zzfwk = zzelx4;
        this.zzfwl = zzelx5;
        this.zzfrw = zzelx6;
        this.zzgnb = zzelx7;
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzctx(this.zzfwi.get(), this.zzfwj.get(), this.zzgna.get(), this.zzfwk.get(), this.zzfwl.get(), this.zzfrw.get(), this.zzgnb.get());
    }
}
