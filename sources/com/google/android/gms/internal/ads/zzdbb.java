package com.google.android.gms.internal.ads;

import android.content.Context;
public final class zzdbb implements zzelo<zzdaz> {
    private final zzelx<zzdvw> zzerr;
    private final zzelx<Context> zzert;

    private zzdbb(zzelx<zzdvw> zzelx, zzelx<Context> zzelx2) {
        this.zzerr = zzelx;
        this.zzert = zzelx2;
    }

    public static zzdbb zzaz(zzelx<zzdvw> zzelx, zzelx<Context> zzelx2) {
        return new zzdbb(zzelx, zzelx2);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzdaz(this.zzerr.get(), this.zzert.get());
    }
}
