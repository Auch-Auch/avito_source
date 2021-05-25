package com.google.android.gms.internal.ads;

import android.content.Context;
public final class zzddn implements zzelo<zzddl> {
    private final zzelx<Context> zzert;
    private final zzelx<String> zzeyb;

    private zzddn(zzelx<Context> zzelx, zzelx<String> zzelx2) {
        this.zzert = zzelx;
        this.zzeyb = zzelx2;
    }

    public static zzddn zzbf(zzelx<Context> zzelx, zzelx<String> zzelx2) {
        return new zzddn(zzelx, zzelx2);
    }

    public static zzddl zzu(Context context, String str) {
        return new zzddl(context, str);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return zzu(this.zzert.get(), this.zzeyb.get());
    }
}
