package com.google.android.gms.internal.ads;

import android.content.Context;
public final class zzblx implements zzelo<zzbly> {
    private final zzelx<Context> zzert;
    private final zzelx<zzqo> zzfmd;

    private zzblx(zzelx<Context> zzelx, zzelx<zzqo> zzelx2) {
        this.zzert = zzelx;
        this.zzfmd = zzelx2;
    }

    public static zzblx zza(zzelx<Context> zzelx, zzelx<zzqo> zzelx2) {
        return new zzblx(zzelx, zzelx2);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzbly(this.zzert.get(), this.zzfmd.get());
    }
}
