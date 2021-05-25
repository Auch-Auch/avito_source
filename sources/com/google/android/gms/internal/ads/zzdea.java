package com.google.android.gms.internal.ads;

import android.content.Context;
public final class zzdea implements zzelo<zzddy> {
    private final zzelx<zzdvw> zzerr;
    private final zzelx<Context> zzert;
    private final zzelx<zzbbg> zzfkr;

    private zzdea(zzelx<zzdvw> zzelx, zzelx<Context> zzelx2, zzelx<zzbbg> zzelx3) {
        this.zzerr = zzelx;
        this.zzert = zzelx2;
        this.zzfkr = zzelx3;
    }

    public static zzdea zzu(zzelx<zzdvw> zzelx, zzelx<Context> zzelx2, zzelx<zzbbg> zzelx3) {
        return new zzdea(zzelx, zzelx2, zzelx3);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzddy(this.zzerr.get(), this.zzert.get(), this.zzfkr.get());
    }
}
