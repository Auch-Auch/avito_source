package com.google.android.gms.internal.ads;

import android.content.Context;
public final class zzdfx implements zzelo<zzdfv> {
    private final zzelx<zzdvw> zzerr;
    private final zzelx<Context> zzert;
    private final zzelx<zztc> zzesv;

    public zzdfx(zzelx<zztc> zzelx, zzelx<zzdvw> zzelx2, zzelx<Context> zzelx3) {
        this.zzesv = zzelx;
        this.zzerr = zzelx2;
        this.zzert = zzelx3;
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzdfv(this.zzesv.get(), this.zzerr.get(), this.zzert.get());
    }
}
