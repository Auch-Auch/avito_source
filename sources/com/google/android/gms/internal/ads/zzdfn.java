package com.google.android.gms.internal.ads;

import android.content.Context;
public final class zzdfn implements zzelo<zzdfl> {
    private final zzelx<zzdvw> zzerr;
    private final zzelx<Context> zzert;
    private final zzelx<zzass> zzesv;
    private final zzelx<String> zzfsc;

    public zzdfn(zzelx<zzass> zzelx, zzelx<Context> zzelx2, zzelx<String> zzelx3, zzelx<zzdvw> zzelx4) {
        this.zzesv = zzelx;
        this.zzert = zzelx2;
        this.zzfsc = zzelx3;
        this.zzerr = zzelx4;
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzdfl(this.zzesv.get(), this.zzert.get(), this.zzfsc.get(), this.zzerr.get());
    }
}
