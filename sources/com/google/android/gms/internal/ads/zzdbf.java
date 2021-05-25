package com.google.android.gms.internal.ads;

import android.content.Context;
public final class zzdbf implements zzelo<zzdbd> {
    private final zzelx<zzdvw> zzerr;
    private final zzelx<Context> zzert;

    public zzdbf(zzelx<zzdvw> zzelx, zzelx<Context> zzelx2) {
        this.zzerr = zzelx;
        this.zzert = zzelx2;
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzdbd(this.zzerr.get(), this.zzert.get());
    }
}
