package com.google.android.gms.internal.ads;

import android.content.Context;
public final class zzcqh implements zzelo<zzcqi> {
    private final zzelx<Context> zzert;

    private zzcqh(zzelx<Context> zzelx) {
        this.zzert = zzelx;
    }

    public static zzcqh zzaf(zzelx<Context> zzelx) {
        return new zzcqh(zzelx);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzcqi(this.zzert.get());
    }
}
